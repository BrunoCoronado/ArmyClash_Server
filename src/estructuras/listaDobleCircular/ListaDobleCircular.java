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
    
//    public void insertarC(Object valor){
//        if(primero == null){
//            //primero = new NodoLC(valor);
//            ultimo = primero;
//            primero.anterior = ultimo;
//            primero.siguiente = ultimo;
//            ultimo.anterior = primero;
//            ultimo.siguiente = primero;
//        }else{
//            NodoLC tmp = ultimo;
//            //ultimo = new NodoLC(valor);
//            ultimo.siguiente = primero;
//            ultimo.anterior = tmp;
//            tmp.siguiente = ultimo;
//            primero.anterior = ultimo;
//        }
//    }
    
    public void insertar(Object valor, int capa){
        if(primero == null){
            primero = new NodoLC(valor, capa);
            ultimo = primero;
            primero.anterior = ultimo;
            primero.siguiente = ultimo;
            ultimo.anterior = primero;
            ultimo.siguiente = primero;
        }else{
            NodoLC nuevo = new NodoLC(valor, capa);
            NodoLC tmp = primero;
            do{
                if(tmp.siguiente.capa > capa){//nos paramos uno antes de la capa que queremos ingresar
                    break;
                }
                tmp = tmp.siguiente;
            }while(tmp.siguiente != primero);
            if(tmp.capa < capa){//lo insertamos despues del nodo tmp donde nos posicionamos
                NodoLC siguienteTmp = tmp.siguiente;
                tmp.siguiente = nuevo;
                nuevo.anterior = tmp;
                siguienteTmp.anterior = nuevo;
                nuevo.siguiente = siguienteTmp;
                if(tmp == ultimo){
                    ultimo = nuevo;
                }
            }else{//si no lo insertamos antes del nodo tmp donde estamos posicionados
                NodoLC anteriorTmp = tmp.anterior;
                tmp.anterior = nuevo;
                nuevo.siguiente = tmp;
                anteriorTmp.siguiente = nuevo;
                nuevo.anterior = anteriorTmp;
                if(tmp == primero){
                    primero = nuevo;
                }
            }
        }
    }
    
    
    public void mostrar(){
        NodoLC tmp = primero;
        do{
            System.out.print(tmp.valor + " - CAPA "+tmp.capa+"  ");
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
    
    public void mostrarPuntas(){
        System.out.println("PRIMERO "+primero.capa+" ANTERIOR PRIMERO "+primero.anterior.capa);
        System.out.println("ULTIMO "+ultimo.capa+" SIGUIENTE ULTIMO "+ultimo.siguiente.capa);
        System.out.println();
    }
}
