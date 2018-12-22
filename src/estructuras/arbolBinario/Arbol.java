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
public class Arbol {
    public NodoA raiz = null;
    
    public void insertar(Tropa tropa){
        if(raiz != null)
            insertar(tropa, raiz);
        else
            raiz = new NodoA(tropa);
    }
    
    private void insertar(Tropa tropa, NodoA tmp){
        if(tropa.getId() < tmp.tropa.getId()){//insertamos a la izquierda del nodo
            if(tmp.izq != null)
                insertar(tropa, tmp.izq);
            else{
                tmp.izq = new NodoA(tropa, tmp);
            }
        }else if(tropa.getId() > tmp.tropa.getId()){//insertamos a la derecha del nodo
            if(tmp.der != null)
                insertar(tropa, tmp.der);
            else
                tmp.der = new NodoA(tropa, tmp);
        }
    }
    
    public void eliminar(int id){
        if(raiz != null){
            if(id != raiz.tropa.getId())
                eliminar(id, raiz);
        }
    }
    
    private void eliminar(int id, NodoA tmp){
        if(id < tmp.tropa.getId()){//si es menor procedo a analizar el lado izquierdo
            if(tmp.izq != null){//si el hijo izquierdo tiene contenido
                if(tmp.izq.tropa.getId() != id){//si el hijo izquierdo no es el que busco
                    eliminar(id, tmp.izq);//sigo buscando en el lado izquierdo 
                }else{//si es el que busco eliminar hijo izquierdo
                    NodoA eliminar = tmp.izq;//guardo el nodo que quiero eliminar
                    if(eliminar.izq == null && eliminar.der == null){//verifico si es un nodo hoja, si lo es->
                        tmp.izq = null;//elimino la hoja
                    }else if(eliminar.izq != null && eliminar.der == null){//si no es una hoja y tiene hijos verificamos cada caso
                        eliminar.izq.padre = tmp;//cambio el padre del hijo del nodo al que voy a eliminar
                        tmp.der = eliminar.izq;//pasos los del nodo eliminado al padre
                    }else if(eliminar.izq == null && eliminar.der != null){
                        eliminar.der.padre = tmp;//cambio el padre del hijo del nodo al que voy a eliminar
                        tmp.izq = eliminar.der;//pasos los del nodo eliminado al padre
                    }else{//al llegar a este punto sabemos que tiene dos hijos
                        NodoA predecesor = predecesor(eliminar.izq);//buscamos el mayor de los menores
                        Tropa aux = eliminar.tropa;//guardamos el valor del nodo que vamos a eliminar
                        eliminar.tropa = predecesor.tropa;//cambiamos el valore del nodo que vamos a eliminar con el valor del predecesor
                        predecesor.tropa = aux;//cambiamos el valore del predecesor con el valore del nodo que vamos a eliminar
                        eliminarHijo(aux.getId(), predecesor.padre.tropa.getId(), raiz);//eliminamos el nodo predecesor con el valor cambiado partiendo del padre del predecesor
                    }
                }
            }
       }else if(id > tmp.tropa.getId()){//si es mayor procedo a analizar el lado derecho
            if(tmp.der != null){//si el hijo derecho tiene contenido
                if(tmp.der.tropa.getId() != id){//si el hijo derecho no es el que busco
                    eliminar(id, tmp.der);//sigo buscando en el lado derecho
                }else{//si es el que busco eliminar hijo derecho
                    NodoA eliminar = tmp.der;
                    if(eliminar.izq == null && eliminar.der == null){//verifico si es un nodo hoja, si lo es->
                        tmp.der = null;//elimino la hoja
                    }else if(eliminar.izq != null && eliminar.der == null){//si no es una hoja y tiene hijos verificamos cada caso
                        tmp.der = eliminar.izq;
                    }else if(eliminar.izq == null && eliminar.der != null){
                        tmp.izq = eliminar.der;
                    }else{//al llegar a este punto sabemos que tiene dos hijos
                        NodoA predecesor = predecesor(eliminar.izq);//buscamos el mayor de los menores
                        Tropa aux = eliminar.tropa;//guardamos el valor del nodo que vamos a eliminar
                        eliminar.tropa = predecesor.tropa;//cambiamos el valore del nodo que vamos a eliminar con el valor del predecesor
                        predecesor.tropa = aux;//cambiamos el valore del predecesor con el valore del nodo que vamos a eliminar
                        eliminarHijo(aux.getId(), predecesor.padre.tropa.getId(), raiz);//eliminamos el nodo predecesor con el valor cambiado partiendo del padre del predecesor
                    }
                }
            }
        }
    }
    
    private void eliminarHijo(int id, int padre, NodoA tmp){//tenemos que buscar al padre en el arbol
        if(padre < tmp.tropa.getId()){//verificamos si es menor
            if(tmp.izq != null)//verificamos que el lador izquierdo a donde vamos no sea nulo
                eliminarHijo(id, padre, tmp.izq);//seguimos buscando
        }else if(padre > tmp.tropa.getId()){//verificamos si es mayor
            if(tmp.der != null)//verificamos que el lado derecho a donde vamos no sea nulo
                eliminarHijo(id, padre, tmp.der);//seguimos buscando
        }else{//cuando lleguemos a este punto quiere decir que estamos en el padre
            if(tmp.izq != null){//analizamos hijo izquierdo
                if(tmp.izq.tropa.getId() == id){//verificamos que sea el hijo que buscamos
                    NodoA eliminar = tmp.izq;//guardo el nodo que quiero eliminar
                    if(eliminar.izq == null && eliminar.der == null){//verifico si es un nodo hoja, si lo es->
                        tmp.izq = null;//elimino la hoja
                    }else if(eliminar.izq != null && eliminar.der == null){//si no es una hoja y tiene hijos verificamos cada caso
                        eliminar.izq.padre = tmp;//cambio el padre del hijo del nodo al que voy a eliminar
                        tmp.der = eliminar.izq;//pasos los del nodo eliminado al padre
                    }else if(eliminar.izq == null && eliminar.der != null){
                        eliminar.der.padre = tmp;//cambio el padre del hijo del nodo al que voy a eliminar
                        tmp.izq = eliminar.der;//pasos los del nodo eliminado al padre
                    }
                }
            }else if(tmp.der != null){//analizamos hijo derecho
                if(tmp.der.tropa.getId() == id){//verificamos que sea el hijo que buscamos
                    NodoA eliminar = tmp.der;
                    if(eliminar.izq == null && eliminar.der == null){//verifico si es un nodo hoja, si lo es->
                        tmp.der = null;//elimino la hoja
                    }else if(eliminar.izq != null && eliminar.der == null){//si no es una hoja y tiene hijos verificamos cada caso
                        tmp.der = eliminar.izq;
                    }else if(eliminar.izq == null && eliminar.der != null){
                        tmp.izq = eliminar.der;
                    }
                }
            }
        }
    }
    
    private NodoA predecesor(NodoA tmp){//espero recibir el nodo del lado de los menores, para proceder a buscar el mayor de los menores
        if(tmp.der != null)
            return predecesor(tmp.der);
        return tmp;
    }
    
    public void preorden(){
        preorden(raiz);
        System.out.println();
    }
    
    private void preorden(NodoA tmp){
        if(tmp != null){
            System.out.print(tmp.tropa.getId() +"  ");
            preorden(tmp.izq);
            preorden(tmp.der);
        }
    }
    
    public void inorden(){
        inorden(raiz);
        System.out.println();
    }
    
    private void inorden(NodoA tmp){
        if(tmp != null){
            inorden(tmp.izq);
            System.out.print(tmp.tropa.getId() +"  ");
            inorden(tmp.der);
        }
    }
    
    public void postorden(){
        postorden(raiz);
        System.out.println();
    }
    
    private void postorden(NodoA tmp){
        if(tmp != null){
            postorden(tmp.izq);
            postorden(tmp.der);
            System.out.print(tmp.tropa.getId() +"  ");
        }
    }
    
    public boolean  existe(int id){
        if(raiz != null){
            if(raiz.tropa.getId() != id){
                return existe(id, raiz);
            }
            return true;
        }
        return false;
    }
    
    private boolean existe(int id, NodoA tmp){
        if(id < tmp.tropa.getId()){
            if(tmp.izq != null){
                if(tmp.izq.tropa.getId() == id)
                    return true;
                return existe(id, tmp.izq);
            }else
                return false;
        }else if(id > tmp.tropa.getId()){
            if(tmp.der != null){
                if(tmp.der.tropa.getId() == id)
                    return true;
                return existe(id, tmp.der);
            }else
                return false;
        }
        return false;
    }
    
    public String obtenerContenidoArbol(){
        return contenidoArbol(raiz, "");
    }
    
    private String contenidoArbol(NodoA tmp, String contenido){
        if(tmp != null){
            contenido += tmp.tropa.getId()+","+tmp.tropa.getNombre()+","+tmp.tropa.getPosicionX()+","+tmp.tropa.getPosicionY()+"\n";
            contenido = contenidoArbol(tmp.izq, contenido);
            contenido = contenidoArbol(tmp.der, contenido);
        }
        return contenido;
    }
}
