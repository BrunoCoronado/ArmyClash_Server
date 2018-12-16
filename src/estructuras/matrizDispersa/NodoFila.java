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
public class NodoFila {
    int numFila;
    NodoFila abajo;
    NodoCelda derecha;

    public NodoFila(int numFila) {
        this.numFila = numFila;
        abajo = null;
        derecha = null;
    }
}
