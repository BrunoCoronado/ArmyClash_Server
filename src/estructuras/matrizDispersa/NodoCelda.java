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
public class NodoCelda {
    Object valor;
    NodoCelda arriba;
    NodoCelda abajo;
    NodoCelda izquierda;
    NodoCelda derecha;
    int numColumna;
    int numFila;

    public NodoCelda(Object contenido, int numColumna, int numFila) {
        this.valor = contenido;
        this.numColumna = numColumna;
        this.numFila = numFila;
        arriba = null;
        abajo = null;
        izquierda = null;
        derecha = null;
    }
}
