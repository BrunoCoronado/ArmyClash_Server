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
public class ListaDobleCircular {
    NodoLC primero = null;
    NodoLC ultimo = null;
    
    public void insertar(Object valor){
        if(primero == null){
            primero = new NodoLC(valor);
            ultimo = primero;
            primero.anterior = ultimo;
            primero.siguiente = ultimo;
            ultimo.anterior = primero;
            ultimo.siguiente = primero;
        }else{
            NodoLC tmp = ultimo;
            ultimo = new NodoLC(valor);
            ultimo.siguiente = primero;
            ultimo.anterior = tmp;
            tmp.siguiente = ultimo;
            primero.anterior = ultimo;
        }
    }
    
    public void mostrar(){
        NodoLC tmp = primero;
        do{
            System.out.print(tmp.valor + "    ");
            tmp = tmp.siguiente;
        }while(tmp != primero);
        System.out.println();
    }
    
    public void mostrarInverso(){
        NodoLC tmp = ultimo;
        do{
            System.out.print(tmp.valor + "    ");
            tmp = tmp.anterior;
        }while(tmp != ultimo);
        System.out.println();
    }
}
