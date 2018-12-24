/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.listaDobleCircular;

/**
 *
 * @author bruno
 */
public class NodoLC {
    public Object valor;
    public int capa;
    public NodoLC anterior;
    public NodoLC siguiente;

    public NodoLC(Object valor, int capa) {
        this.valor = valor;
        this.capa = capa;
        anterior = null;
        siguiente = null;
    }
}
