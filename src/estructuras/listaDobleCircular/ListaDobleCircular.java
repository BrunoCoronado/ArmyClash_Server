/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.listaDobleCircular;

import estructuras.matrizDispersa.Matriz;

/**
 *
 * @author bruno
 */
public class ListaDobleCircular {
    public NodoLC primero = null;
    public NodoLC ultimo = null;
    
    public void insertar(Object valor, int capa){
        if(primero == null){
            primero = new NodoLC(valor, capa);
            ultimo = primero;
            primero.anterior = ultimo;
            primero.siguiente = ultimo;
            ultimo.anterior = primero;
            ultimo.siguiente = primero;
        }else{
            NodoLC nuevo = new NodoLC(valor, capa);
            NodoLC tmp = primero;
            do{
                if(tmp.siguiente.capa > capa){//nos paramos uno antes de la capa que queremos ingresar
                    break;
                }
                tmp = tmp.siguiente;
            }while(tmp.siguiente != primero);
            if(tmp.capa < capa){//lo insertamos despues del nodo tmp donde nos posicionamos
                NodoLC siguienteTmp = tmp.siguiente;
                tmp.siguiente = nuevo;
                nuevo.anterior = tmp;
                siguienteTmp.anterior = nuevo;
                nuevo.siguiente = siguienteTmp;
                if(tmp == ultimo){
                    ultimo = nuevo;
                }
            }else{//si no lo insertamos antes del nodo tmp donde estamos posicionados
                NodoLC anteriorTmp = tmp.anterior;
                tmp.anterior = nuevo;
                nuevo.siguiente = tmp;
                anteriorTmp.siguiente = nuevo;
                nuevo.anterior = anteriorTmp;
                if(tmp == primero){
                    primero = nuevo;
                }
            }
        }
    }
    
    public boolean eliminar(int capa){
        if(primero != null){
            NodoLC tmp = primero;
            Boolean encontrado = false;
            do{
                if(tmp.capa == capa){
                    encontrado = true;
                    break;
                }
                tmp = tmp.siguiente;
            }while(tmp != primero);
            if(encontrado){
                if(tmp.anterior != tmp.siguiente && tmp != tmp.siguiente){
                    NodoLC anterior = tmp.anterior;
                    anterior.siguiente = tmp.siguiente;
                    tmp.siguiente.anterior = anterior;
                    if(tmp == primero){
                        primero = anterior.siguiente;
                    }
                    if(tmp == ultimo){
                        ultimo = anterior;
                    }
                }else{
                    if(tmp != tmp.siguiente){
                        primero = tmp.anterior;
                        ultimo = primero;
                        primero.anterior = ultimo;
                        primero.siguiente = ultimo;
                        ultimo.anterior = primero;
                        ultimo.siguiente = primero;
                    }else{
                        primero = null;
                        ultimo = null;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }
    
    public void mostrar(){
        if(primero != null){
            NodoLC tmp = primero;
            do{
                System.out.print("CAPA "+tmp.capa+"  ");
                tmp = tmp.siguiente;
            }while(tmp != primero);
            System.out.println();
        }
    }
    
    public void mostrarPuntas(){
        if(primero != null){
            System.out.println("PRIMERO "+primero.capa+" ANTERIOR PRIMERO "+primero.anterior.capa);
            System.out.println("ULTIMO "+ultimo.capa+" SIGUIENTE ULTIMO "+ultimo.siguiente.capa);
            System.out.println();
        }
    }
    
    public boolean  existe(int capa){
        if(primero != null){
            NodoLC tmp = primero;
            do{
                if(tmp.capa == capa){
                    return true;
                }
                tmp = tmp.siguiente;
            }while(tmp != primero);
        }
        return false;
    } 
    
    public void sobrescribir(Object valor, int capa){
        if(primero != null){
            NodoLC tmp = primero;
            do{
                if(tmp.capa == capa){
                    tmp.valor = valor;
                    break;
                }
                tmp = tmp.siguiente;
            }while(tmp != primero);
        }
    }
    
    public int filasMapa;
    public int columnasMapa;
    
    public String generarMapa(){
        if(primero != null){
            Matriz mapa = new Matriz();
            NodoLC tmp = primero;
            do{
                Matriz matriz = (Matriz)tmp.valor;
                String contenidoCapa = matriz.obtenerContenido();
                String[] valores = contenidoCapa.split("\n");
                for (String valore : valores) 
                    mapa = llenarMapaCapaCliente(valore, mapa);
                tmp = tmp.siguiente;
            }while(tmp != primero);
            filasMapa = mapa.numeroFilasMaximo();
            columnasMapa = mapa.numeroColumnasMaximo();
            return mapa.obtenerContenido();
        }
        return null;
    }
    
    public Matriz obtenerMapa(){
        if(primero != null){
            Matriz mapa = new Matriz();
            NodoLC tmp = primero;
            do{
                Matriz matriz = (Matriz)tmp.valor;
                String contenidoCapa = matriz.obtenerContenidoConContador();
                String[] valores = contenidoCapa.split("\n");
                for (String valore : valores) 
                    mapa = llenarMapaCapa(valore, mapa);
                tmp = tmp.siguiente;
            }while(tmp != primero);
            filasMapa = mapa.numeroFilasMaximo();
            columnasMapa = mapa.numeroColumnasMaximo();
            return mapa;
        }
        return null;
    }
    
    private Matriz llenarMapaCapaCliente(String contenido, Matriz mapa){
            String[] informacion = contenido.split(",");
            int columna = Integer.parseInt(informacion[1]);
            int fila = Integer.parseInt(informacion[2]);
            String valor = informacion[0];
            mapa.agregarColumna(columna);
            mapa.agregarFila(fila);
            if(!mapa.existeCelda(valor, columna, fila))
                mapa.insertarCelda(valor, columna, fila);
            else
                mapa.sobrescribirCelda(valor, columna, fila);
            return mapa;
    }
    
    private Matriz llenarMapaCapa(String contenido, Matriz mapa){
            String[] informacion = contenido.split(",");
            int columna = Integer.parseInt(informacion[1]);
            int fila = Integer.parseInt(informacion[2]);
            String valor = informacion[0];
            int contador = Integer.parseInt(informacion[3]);
            mapa.agregarColumna(columna);
            mapa.agregarFila(fila);
            if(!mapa.existeCelda(valor, columna, fila))
                mapa.insertarCelda(valor, columna, fila, contador);
            else
                mapa.sobrescribirCelda(valor, columna, fila, contador);
            return mapa;
    }
    
    
    public Matriz ObtenerCapa(int capa){
        if(primero != null){
            NodoLC tmp = primero;
            do{
                if(tmp.capa == capa){
                    return (Matriz)tmp.valor;
                }
                tmp = tmp.siguiente;
            }while(tmp != primero);
        }
        return null;
    }
    
    public void aumentarContadorCeldaCapa(int capa, int x, int y){
        if(primero != null){
            NodoLC tmp = primero;
            do{
                if(tmp.capa == capa){
                    ((Matriz)tmp.valor).aumentarContadorCelda(x, y);
                }
                tmp = tmp.siguiente;
            }while(tmp != primero);
        }
    }
    
    public void reiniciarContadoresCapas(){
        if(primero != null){
            NodoLC tmp = primero;
            do{
                ((Matriz)tmp.valor).reiniciarContadores();
                tmp = tmp.siguiente;
            }while(tmp != primero);
        }
    }
}
