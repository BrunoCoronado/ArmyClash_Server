/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.archivos;

import estructuras.arbolBinario.Arbol;
import estructuras.matrizDispersa.Matriz;
import java.io.BufferedReader;
import java.io.FileReader;
import sistema.bean.Tropa;

/**
 *
 * @author bruno
 */
public class Archivo {
    private Matriz capa;
    private Arbol arbol;
    public String log = "";
    
    public void cargarCapa(String path, int numCapa){
        log += "Cargando Capa...\n";
        try{
            BufferedReader reader = new BufferedReader(new FileReader(path));
            capa = new Matriz();//instanciamos un nuevo mapa, que es el mapa que vamos a llenar
            String contenido = reader.readLine();
            while(contenido != null){
                if(contenido.contains(obtenerTipoContenido(numCapa))){
                    llenarMapa(contenido);
                }else{
                    throw new Exception("***CONTENIDO INVALIDO***\n");
                }
                contenido = reader.readLine();
            }
           if(main.Main.capas.existe(numCapa))
               main.Main.capas.sobrescribir(capa, numCapa);
           else
                main.Main.capas.insertar(capa, numCapa);
            log += "***CAPA CARGADA***\n";
        }catch(Exception ex){
            log += "!!!ERROR DURANTE CARGA!!!\n";
            log += ex.getMessage();
        }
    }
    
    private void llenarMapa(String contenido){//formato entrada columna,fila;tipo
        try{
            if(contenido.contains("\uFEFF")){
                contenido = contenido.replaceAll("\uFEFF", "");
            }
            int columna = Integer.parseInt(contenido.substring(0, contenido.indexOf(",")));//obtenemos la columna -> obteniendo el substring antes de la coma que separa columnas-
            int fila = Integer.parseInt(contenido.substring((contenido.indexOf(",") + 1), contenido.indexOf(";")));//obtenemos la fila empezando por uno despues de la primera coma(debido a que es inclusivo el primer indice)
            String tipo = contenido.substring((contenido.indexOf(";") + 1));//obtenemos el tipo empezando por uno despues del primer ; (debido a que es inclusivo el primer indice)
            capa.agregarColumna(columna);//este metodo incluye verificacion de existencia
            capa.agregarFila(fila);//este metodo incluye verificacion de existencia
            if(!capa.existeCelda(tipo, columna, fila))
                capa.insertarCelda(tipo, columna, fila);
        }catch(Exception ex){
            ex.printStackTrace();
            log += "!!!ERROR AGREGANDO NODO - ARCHIVO CON ERRORES!!!\n";
        }
    }
    
    public String obtenerTipoContenido(int capa){
        switch(capa){
            case 0:
                return "agua";
            case 1:
                return "grama";
            case 2:
                return "arbol";
            case 3:
                return "carretera";
            case 4:
                return "montania";
        }
        return "";
    }
    
    public void cargarTropas(String path, int jugador){
        log += "Cargando Tropas...\n";
        try{
            BufferedReader reader = new BufferedReader(new FileReader(path));
            arbol = new Arbol();
            String contenido = reader.readLine();
            while(contenido != null){
                if(contenido.contains("\uFEFF")){
                    contenido = contenido.replaceAll("\uFEFF", "");
                }
                llenarArbol(contenido);
                contenido = reader.readLine();
            }
            arbol.inorden();
            if(jugador == 1)
                main.Main.arbolJugador1 = arbol;
            else
                main.Main.arbolJugador2 = arbol;
            log += "***TROPAS CARGADAS***\n";
        }catch(Exception ex){
            ex.printStackTrace();
            log += "!!!Error durante la carga del archivo!!!\n";
        }
    }
    
    public void cargarTropasCliente(String contenido, int jugador){
        try{
            arbol = new Arbol();
            String[] informacion = contenido.split("\n");
            for(int i = 0; i < informacion.length ; i++){
                llenarArbol(informacion[i]);
            }
            sistema.ui.VentanaConfiguracion.txtLog.setText(sistema.ui.VentanaConfiguracion.txtLog.getText()+ "Cargando: Tropas Jugador "+jugador+" De: Cliente\n");
            if(jugador == 1)
                main.Main.arbolJugador1 = arbol;
            else
                main.Main.arbolJugador2 = arbol;
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    private void llenarArbol(String contenido){
        try{
            String parteA = contenido.substring(0, contenido.indexOf(";"));
            String tipo = contenido.substring(contenido.indexOf(";")+1);
            String[] partesA = parteA.split(",");
            int columna = Integer.parseInt(partesA[0]);
            int fila = Integer.parseInt(partesA[1]);
            int id = Integer.parseInt(partesA[2]);
            arbol.insertar(new Tropa(id, tipo, columna, fila));
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
