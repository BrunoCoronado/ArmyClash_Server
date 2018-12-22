/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.matrizDispersa;

/**
 *
 * @author bruno
 */
public class Matriz {
    NodoFila primeroFila;
    NodoColumna primeroColumna;
    
    public void agregarFila(int numFila){
        if(primeroFila != null){
            if(!existeFila(numFila)){
                NodoFila tmp = primeroFila;
                primeroFila = new NodoFila(numFila);
                primeroFila.abajo = tmp;
                ordenarFilas();
            }
        }else{//insertarmos en la primera posicion
            primeroFila = new NodoFila(numFila);
        }
    }
    
    public void agregarColumna(int numColumna){
        if(primeroColumna != null){//insertarmos en la primera posicion
            if(!existeColumna(numColumna)){
                NodoColumna tmp = primeroColumna;
                primeroColumna = new NodoColumna(numColumna);
                primeroColumna.siguiente = tmp;
                ordenarColumnas();
            }
        }else{
            primeroColumna = new NodoColumna(numColumna);
        }
    }
    
    public void insertarCelda(Object valor, int numColumna, int numFila){//esta insercion lo pone en el lugar que deberia("ordenado")
        NodoColumna tmpColumna = primeroColumna;
        NodoFila tmpFila = primeroFila;
        NodoCelda nuevo = new NodoCelda(valor, numColumna,numFila);
        while(tmpColumna != null){//recorremos las cabeceras de las columnas
            if(tmpColumna.numColumna == numColumna){//si es la columna que buscamos
                NodoCelda tmpCelda = tmpColumna.abajo;//empezamos a recorrer los nodos que estan por debajo, buscando la fila
                if(tmpCelda != null){//si la columna tiene celdas
                    NodoCelda tmpCeldaAbajo = tmpCelda.abajo;//hacemos un temporal del que esta abajo
                    while(tmpCeldaAbajo != null){//mientras que exista alguno abajo
                        if(tmpCeldaAbajo.numFila > numFila){//hacemos que el temporal de abajo uno despues de donde queremos insertar
                            break;
                        }
                        tmpCelda = tmpCelda.abajo;
                        tmpCeldaAbajo = tmpCelda.abajo;
                    }//una vez posicionado donde deberia insertar, se inserta entre los nodos
                    nuevo.arriba = tmpCelda;
                    tmpCelda.abajo = nuevo;
                    if(tmpCeldaAbajo != null){
                        nuevo.abajo = tmpCeldaAbajo;
                        tmpCeldaAbajo.arriba = nuevo;
                    }
                }else{
                    tmpColumna.abajo = nuevo;
                }
                break;
            }
            tmpColumna = tmpColumna.siguiente;
        }
        //repetimos el codigo anterior, pero ahora para las filas
        while(tmpFila != null){
            if(tmpFila.numFila == numFila){
                NodoCelda tmpCelda = tmpFila.derecha;
                if(tmpCelda != null){
                    NodoCelda tmpCeldaDerecha = tmpCelda.derecha;
                    while(tmpCeldaDerecha != null){
                        if(tmpCeldaDerecha.numColumna > numColumna){
                            break;
                        }
                        tmpCelda = tmpCelda.derecha;
                        tmpCeldaDerecha = tmpCelda.derecha;
                    }
                    nuevo.izquierda = tmpCelda;
                    tmpCelda.derecha = nuevo;
                    if(tmpCeldaDerecha != null){
                        nuevo.derecha = tmpCeldaDerecha;
                        tmpCeldaDerecha.izquierda = nuevo;
                    }
                }else{
                    tmpFila.derecha = nuevo;
                }
                break;
            }
            tmpFila = tmpFila.abajo;
        }
    }
    
    public void sobrescribirCelda(Object valor, int numColumna, int numFila){
        NodoColumna tmpColumna = primeroColumna;
        while(tmpColumna != null){
            if(tmpColumna.numColumna == numColumna){
                NodoCelda tmpCelda = tmpColumna.abajo;
                while(tmpCelda != null){
                    if(tmpCelda.numFila == numFila){
                        tmpCelda.valor = valor;
                    }
                    tmpCelda = tmpCelda.abajo;
                }
                break;
            }
            tmpColumna = tmpColumna.siguiente;
        }
    }
    
    private void ordenarFilas(){
        if(primeroFila != null){
          NodoFila actual = primeroFila;
          int aux;
          NodoCelda auxCelda;
          while(actual.abajo != null){
              NodoFila posterior = actual.abajo;
              while(posterior != null){
                  if(actual.numFila > posterior.numFila){
                      aux = actual.numFila;
                      auxCelda = actual.derecha;
                      actual.numFila = posterior.numFila;
                      actual.derecha = posterior.derecha;
                      posterior.numFila = aux;
                      posterior.derecha = auxCelda;
                  }
                  posterior = posterior.abajo;
              }
              actual = actual.abajo;
          }
        }
    }
    
    private void ordenarColumnas(){
        if(primeroColumna != null){
          NodoColumna actual = primeroColumna;
          int aux;
          NodoCelda auxCelda;
          while(actual.siguiente != null){
              NodoColumna posterior = actual.siguiente;
              while(posterior != null){
                  if(actual.numColumna > posterior.numColumna){
                      aux = actual.numColumna;
                      auxCelda = actual.abajo;
                      actual.numColumna = posterior.numColumna;
                      actual.abajo = posterior.abajo;
                      posterior.numColumna = aux;
                      posterior.abajo = auxCelda;
                  }
                  posterior = posterior.siguiente;
              }
              actual = actual.siguiente;
          }
        }
    }
    
    public boolean existeFila(int numFila){
        NodoFila tmp = primeroFila; 
        while(tmp != null){
            if(tmp.numFila == numFila){
                return true;
            }
            tmp = tmp.abajo;
        }
        return false;
    }
    
    public boolean existeColumna(int numColumna){
        NodoColumna tmp = primeroColumna; 
        while(tmp != null){
            if(tmp.numColumna == numColumna){
                return true;
            }
            tmp = tmp.siguiente;
        }
        return false;
    }
    
    public boolean existeCelda(Object valor, int numColumna, int numFila){
        NodoColumna tmpColumna = primeroColumna;
        while(tmpColumna != null){
            if(tmpColumna.numColumna == numColumna){
                NodoCelda tmpCelda = tmpColumna.abajo;
                while(tmpCelda != null){
                    if(tmpCelda.numFila == numFila){
                        return true;
                    }
                    tmpCelda = tmpCelda.abajo;
                }
                break;
            }
            tmpColumna = tmpColumna.siguiente;
        }
        return false;
    }
    
    public void mostrarFilas(){
        NodoFila tmp = primeroFila;
        System.out.print("FILAS: ");
        while(tmp != null){
            System.out.print(tmp.numFila +" ");
            tmp = tmp.abajo;
        }
        System.out.println();
    }
    
    public void mostrarColumnas(){
        NodoColumna tmp = primeroColumna;
        System.out.print("COLUMNAS: ");
        while(tmp != null){
            System.out.print(tmp.numColumna +" ");
            tmp = tmp.siguiente;
        }
        System.out.println();
    }
    
    public void mostrarCelda(int numColumna, int numFila){
        NodoColumna tmpColumna = primeroColumna;
        while(tmpColumna != null){
            if(tmpColumna.numColumna == numColumna){
                NodoCelda tmpCelda = tmpColumna.abajo;
                while(tmpCelda != null){
                    if(tmpCelda.numFila == numFila){
                        System.out.println("Valor: "+tmpCelda.valor+" Columna: "+tmpCelda.numColumna+" Fila: "+tmpCelda.numFila);
                        break;
                    }
                    tmpCelda = tmpCelda.abajo;
                }
                break;
            }
            tmpColumna = tmpColumna.siguiente;
        }
    }
    
    public void mostrarMatriz(){//vamos a mostrar filas enteras, recorriendo columna por columna de cada elemento
        NodoFila tmpFila = primeroFila;
        while(tmpFila != null){
            NodoCelda tmpCelda = tmpFila.derecha;
            while(tmpCelda != null){
                System.out.print("["+tmpCelda.valor+"("+tmpCelda.numColumna+","+tmpCelda.numFila+")]");
                tmpCelda = tmpCelda.derecha;
            }
            System.out.println();
            tmpFila = tmpFila.abajo;
        }
    }
    
    public String obtenerContenido(){
        String contenido = "";
        NodoFila tmpFila = primeroFila;
        while(tmpFila != null){
            NodoCelda tmpCelda = tmpFila.derecha;
            while(tmpCelda != null){
                contenido += tmpCelda.valor+","+tmpCelda.numColumna+","+tmpCelda.numFila+"\n";
                tmpCelda = tmpCelda.derecha;
            }
            tmpFila = tmpFila.abajo;
        }
        return contenido;
    }
    
    public int numeroFilasMaximo(){
        NodoFila tmp = primeroFila;
        while(tmp != null){
            if(tmp.abajo == null){
                break;
            }
            tmp = tmp.abajo;
        }
        return tmp.numFila;
    }
    
    public int numeroColumnasMaximo(){
        NodoColumna tmp = primeroColumna;
        while(tmp != null){
            if(tmp.siguiente == null){
                break;
            }
            tmp = tmp.siguiente;
        }
        return tmp.numColumna;
    }
}
