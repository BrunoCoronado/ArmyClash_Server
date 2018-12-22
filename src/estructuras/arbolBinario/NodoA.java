/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.arbolBinario;

import sistema.bean.Tropa;

/**
 *
 * @author bruno
 */
public class NodoA {
    public Tropa tropa;
    public NodoA izq;
    public NodoA der;
    public NodoA padre;

    public NodoA(Tropa tropa) {
        this.tropa = tropa;
        izq = null;
        der = null;
        padre = null;
    }

    public NodoA(Tropa tropa, NodoA padre) {
        this.tropa = tropa;
        this.padre = padre;
        izq = null;
        der = null;
    }
}
