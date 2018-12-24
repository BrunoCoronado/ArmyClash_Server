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
    public Object valor;
    public NodoCelda arriba;
    public NodoCelda abajo;
    public NodoCelda izquierda;
    public NodoCelda derecha;
    public int contador;
    public int numColumna;
    public int numFila;

    public NodoCelda(Object contenido, int numColumna, int numFila) {
        this.valor = contenido;
        this.numColumna = numColumna;
        this.numFila = numFila;
        contador = 0;
        arriba = null;
        abajo = null;
        izquierda = null;
        derecha = null;
    }
}
