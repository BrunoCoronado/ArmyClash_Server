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
        arbol.insertar(50);
        arbol.insertar(25);
        arbol.insertar(75);
        arbol.insertar(15);
        arbol.insertar(35);
        arbol.insertar(65);
        arbol.insertar(100);
        arbol.insertar(10);
        arbol.insertar(20);
        arbol.insertar(30);
        arbol.insertar(40);
        arbol.insertar(60);
        arbol.insertar(70);
        arbol.insertar(80);
        arbol.insertar(110);
        arbol.inorden();
        System.out.println();
        //arbol.preorden();
        System.out.println();
        //arbol.postorden();
        System.out.println();
        arbol.eliminar(10);
        arbol.inorden();
        System.out.println();
        //arbol.preorden();
        System.out.println();
        //arbol.postorden();
        System.out.println();
        
        arbol.eliminar(110);
        arbol.inorden();
        System.out.println();
        
        arbol.eliminar(100);
        arbol.inorden();
        System.out.println();
        arbol.eliminar(15);
        arbol.inorden();
        System.out.println();
        arbol.eliminar(40);
        arbol.inorden();
        System.out.println();
        arbol.eliminar(60);
        arbol.inorden();
        System.out.println();
        arbol.eliminar(25);
        arbol.inorden();
        System.out.println();
        arbol.eliminar(75);
        arbol.inorden();
        System.out.println();
        arbol.eliminar(70);
        arbol.inorden();
        System.out.println();
        arbol.eliminar(30);
        arbol.inorden();
        System.out.println();
    }
}
