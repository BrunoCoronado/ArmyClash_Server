/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import estructuras.arbolBinario.Arbol;
import estructuras.listaDobleCircular.ListaDobleCircular;
import java.util.Scanner;
import rabbit.Enviar;

/**
 *
 * @author bruno
 */
//CLIENTE
public class Main {

    /**
     * @param args the command line arguments
     */
    //SERVIDOR
    public static void main(String[] args) {
        /*Enviar enviar = new Enviar();
        Scanner scanner = new Scanner(System.in);
        try{
            int maximo = 0;
            while(maximo<=10){
                System.out.println("enviar:");
                enviar.enviarACola(scanner.nextLine());
                System.out.println();
                maximo++;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }*/
//        ListaDobleCircular listaDobleCircular = new ListaDobleCircular();
//        listaDobleCircular.insertar(10,5);
//        listaDobleCircular.mostrar();
//        listaDobleCircular.mostrarPuntas();
//        listaDobleCircular.insertar(20,1);
//        listaDobleCircular.mostrar();
//        listaDobleCircular.mostrarPuntas();
//        listaDobleCircular.insertar(30,4);
//        listaDobleCircular.mostrar();
//        listaDobleCircular.mostrarPuntas();
//        listaDobleCircular.insertar(40,3);
//        listaDobleCircular.mostrar();
//        listaDobleCircular.mostrarPuntas();
//        listaDobleCircular.insertar(50,2);
//        listaDobleCircular.mostrar();
//        listaDobleCircular.mostrarPuntas();
//        listaDobleCircular.eliminar(3);
//        listaDobleCircular.mostrar();
//        listaDobleCircular.mostrarPuntas();
//        listaDobleCircular.eliminar(1);
//        listaDobleCircular.mostrar();
//        listaDobleCircular.mostrarPuntas();
//        listaDobleCircular.eliminar(5);
//        listaDobleCircular.mostrar();
//        listaDobleCircular.mostrarPuntas();
//        listaDobleCircular.eliminar(4);
//        listaDobleCircular.mostrar();
//        listaDobleCircular.mostrarPuntas();
//        listaDobleCircular.eliminar(2);
//        listaDobleCircular.mostrar();
//        listaDobleCircular.mostrarPuntas();

        Arbol arbol = new Arbol();
        arbol.insertar(8);
        arbol.insertar(2);
        arbol.insertar(3);
        arbol.insertar(1);
        arbol.insertar(15);
        arbol.insertar(11);
        arbol.insertar(16);
        arbol.insertar(10);
        arbol.insertar(20);
        arbol.insertar(7);
        arbol.inorden();
        System.out.println();
        arbol.preorden();
        System.out.println();
        arbol.postorden();
        System.out.println();
    }
}
