/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rabbit;

import javax.swing.Timer;

/**
 *
 * @author bruno
 */
public class AdministradorRespuestas extends Thread{
    Timer timer;
    Emisor emisor = new Emisor();
    
    @Override
    public void run() {
       timer = new Timer(2000, (ae) -> {
           if(!main.Main.peticiones.vacio()){
               String peticion = main.Main.peticiones.cola().toString();
               main.Main.peticiones.remover();
               emisor.enviarPeticion(manejarPeticion(peticion));
           }
       });
       timer.start();
        sistema.ui.VentanaConfiguracion.txtLog.setText(sistema.ui.VentanaConfiguracion.txtLog.getText() + "Administrador de respuestas activo\n");
    }
    
    private String  manejarPeticion(String peticion){
        switch(peticion){
            case "mapa": return enviarInformacionMapa();
            case "tropas": return enviarInformacionTropas();
        }
        return "";
    }
    
    private String enviarInformacionMapa(){
        String contenido = main.Main.capas.generarMapa();
        if(contenido != null){
            int filas = main.Main.capas.filasMapa;
            int columnas = main.Main.capas.columnasMapa;
            if(filas != 0 && columnas != 0){
                contenido = filas+"#"+columnas+"#"+contenido;
            }
            sistema.ui.VentanaConfiguracion.txtLog.setText(sistema.ui.VentanaConfiguracion.txtLog.getText() + "---->Enviando mapa a cliente<----\n");
            return contenido + ">m<0";
        }
        sistema.ui.VentanaConfiguracion.txtLog.setText(sistema.ui.VentanaConfiguracion.txtLog.getText() + "---->!Respuesta a peticion del cliente sin contenido!<----\n");
        return "";
    }    
    
    private String enviarInformacionTropas(){
        if(main.Main.arbolJugador1 != null && main.Main.arbolJugador2 != null){
            sistema.ui.VentanaConfiguracion.txtLog.setText(sistema.ui.VentanaConfiguracion.txtLog.getText() + "---->Enviando tropas a cliente<----\n");
            String jugador1 = main.Main.arbolJugador1.obtenerContenidoArbol();
            String jugador2 = main.Main.arbolJugador2.obtenerContenidoArbol();
            return jugador1 + "#" + jugador2+">t<0";
        }
        sistema.ui.VentanaConfiguracion.txtLog.setText(sistema.ui.VentanaConfiguracion.txtLog.getText() + "---->!Respuesta a peticion del cliente sin contenido!<----\n");
        return "";
    }
}
