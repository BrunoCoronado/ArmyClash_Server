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
public class Arbol {
    NodoA raiz = null;
    
    public void insertar(int id){
        if(raiz != null)
            insertar(id, raiz);
        else
            raiz = new NodoA(id);
    }
    
    private void insertar(int id, NodoA tmp){
        if(id < tmp.id){//insertamos a la izquierda del nodo
            if(tmp.izq != null)
                insertar(id, tmp.izq);
            else
                tmp.izq = new NodoA(id);
        }else if(id > tmp.id){//insertamos a la derecha del nodo
            if(tmp.der != null)
                insertar(id, tmp.der);
            else
                tmp.der = new NodoA(id);
        }
    }
    
    public void preorden(){
        preorden(raiz);
    }
    
    private void preorden(NodoA tmp){
        if(tmp != null){
            System.out.print(tmp.id +"  ");
            preorden(tmp.izq);
            preorden(tmp.der);
        }
    }
    
    public void inorden(){
        inorden(raiz);
    }
    
    private void inorden(NodoA tmp){
        if(tmp != null){
            inorden(tmp.izq);
            System.out.print(tmp.id +"  ");
            inorden(tmp.der);
        }
    }
    
    public void postorden(){
        postorden(raiz);
    }
    
    private void postorden(NodoA tmp){
        if(tmp != null){
            postorden(tmp.izq);
            postorden(tmp.der);
            System.out.print(tmp.id +"  ");
        }
    }
}
