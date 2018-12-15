/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.arbolBinario;

/**
 *
 * @author bruno
 */
public class NodoA {
    int posicionX;
    int posicionY;
    int id;
    int vida;
    int alcanceMovimiento;
    int ataque;
    int alcanceAtaque;
    
    NodoA izq;
    NodoA der;
    NodoA padre;

    public NodoA(int id) {
        this.id = id;
        izq = null;
        der = null;
        padre = null;
    }
    
    public NodoA(int id, NodoA padre) {
        this.id = id;
        izq = null;
        der = null;
        this.padre = padre;
    }
}
