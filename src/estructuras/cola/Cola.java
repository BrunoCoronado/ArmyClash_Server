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
public class Cola {
    Nodo cabeza = null;
    
    //insertamos a la cabeza
    public void insertar(Object valor){
        if(cabeza != null){
            Nodo tmp = cabeza;
            cabeza = new Nodo(valor);
            cabeza.siguiente = tmp;
        }else{
            cabeza = new Nodo(valor);
        }
    }
    
    //extraemos en la cola
    public void remover(){
        if(cabeza != null){
            Nodo tmp = cabeza;
            if(tmp.siguiente != null){
                Nodo tmpSiguiente = cabeza.siguiente;
                while(tmpSiguiente != null){
                    if(tmpSiguiente.siguiente == null){
                        break;
                    }
                    tmp = tmp.siguiente;
                    tmpSiguiente = tmp.siguiente;
                }
                tmp.siguiente = null;
            }else{
                cabeza = null;
            }
        }
    }
    
    public Object cola(){
        if(cabeza != null){
            Nodo tmp = cabeza;
            while(tmp != null){
                if(tmp.siguiente == null){
                    break;
                }
                tmp = tmp.siguiente;
            }
            return tmp.valor;
        }
        return null;
    }
    
    public void mostrar(){
        if(cabeza!=null){
            Nodo tmp = cabeza;
            while(tmp!=null){
                System.out.print(tmp.valor+"  ");
                tmp = tmp.siguiente;
            }
            System.out.println();
        }
    }
    
    public boolean vacio(){
        if(cabeza == null)
            return true;
        return false;
    }
}
