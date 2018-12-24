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
public class NodoColumna {
    public int numColumna;
    public NodoColumna siguiente;
    public NodoCelda    abajo;

    public NodoColumna(int numColumna) {
        this.numColumna = numColumna;
        siguiente = null;
        abajo = null;
    }
}
