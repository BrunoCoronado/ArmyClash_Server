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
            NodoFila tmp = primeroFila;
            primeroFila = new NodoFila(numFila);
            primeroFila.abajo = tmp;
            ordenarFilas();
        }else{//insertarmos en la primera posicion
            primeroFila = new NodoFila(numFila);
        }
    }
    
    public void agregarColumna(int numColumna){
        if(primeroColumna != null){//insertarmos en la primera posicion
            NodoColumna tmp = primeroColumna;
            primeroColumna = new NodoColumna(numColumna);
            primeroColumna.siguiente = tmp;
            ordenarColumnas();
        }else{
            primeroColumna = new NodoColumna(numColumna);
        }
    }
    
    public void insertarCelda(Object valor, int numColumna, int numFila){
        NodoColumna tmpColumna = primeroColumna;
        NodoFila tmpFila = primeroFila;
        NodoCelda nuevo = new NodoCelda(valor, numColumna,numFila);
        
        while(tmpColumna != null){
            if(tmpColumna.numColumna == numColumna){
                NodoCelda tmpCelda = tmpColumna.abajo;
                if(tmpCelda == null)
                    tmpColumna.abajo = nuevo;
                else{
                    while(tmpCelda.abajo != null)
                        tmpCelda = tmpCelda.abajo;
                    nuevo.arriba = tmpCelda;
                    tmpCelda.abajo = nuevo;
                }
                break;
            }
            tmpColumna = tmpColumna.siguiente;
        }
        
        while (tmpFila != null){
            if(tmpFila.numFila == numFila){
                NodoCelda tmpCelda = tmpFila.derecha;
                if(tmpCelda == null)
                    tmpFila.derecha = nuevo;
                else{
                    while(tmpCelda.derecha != null)
                        tmpCelda = tmpCelda.derecha;
                    nuevo.izquierda = tmpCelda;
                    tmpCelda.derecha = nuevo;
                }
                break;
            }
            tmpFila = tmpFila.abajo;
        }
    }
    
//    public void insertarCelda(Object valor, int numColumna, int numFila){
//        NodoColumna tmpColumna = primeroColumna;
//        NodoFila tmpFila = primeroFila;
//        NodoCelda nuevo = new NodoCelda(valor, numColumna,numFila);
//        
//        while(tmpColumna != null){
//            if(tmpColumna.numColumna == numColumna){
//                NodoCelda tmpCelda = tmpColumna.abajo;
//                if(tmpCelda == null){
//                    tmpColumna.abajo = nuevo;
//                }
//            }
//            tmpColumna = tmpColumna.siguiente;
//        }
//    }
    
    private void ordenarFilas(){
        if(primeroFila != null){
          NodoFila actual = primeroFila;
          int aux;
          while(actual.abajo != null){
              NodoFila posterior = actual.abajo;
              while(posterior != null){
                  if(actual.numFila > posterior.numFila){
                      aux = actual.numFila;
                      actual.numFila = posterior.numFila;
                      posterior.numFila = aux;
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
          while(actual.siguiente != null){
              NodoColumna posterior = actual.siguiente;
              while(posterior != null){
                  if(actual.numColumna > posterior.numColumna){
                      aux = actual.numColumna;
                      actual.numColumna = posterior.numColumna;
                      posterior.numColumna = aux;
                  }
                  posterior = posterior.siguiente;
              }
              actual = actual.siguiente;
          }
        }
    }
    
    public void mostrarFilas(){
        NodoFila tmp = primeroFila;
        while(tmp != null){
            System.out.print(tmp.numFila +" ");
            tmp = tmp.abajo;
        }
        System.out.println();
    }
    
    public void mostrarColumnas(){
        NodoColumna tmp = primeroColumna;
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
}
