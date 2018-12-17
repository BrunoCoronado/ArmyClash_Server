/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.cola;

/**
 *
 * @author bruno
 */
public class Nodo {
    Object valor;
    Nodo siguiente;
    
    public Nodo(Object valor){
        this.valor = valor;
        siguiente = null;
    }
}
