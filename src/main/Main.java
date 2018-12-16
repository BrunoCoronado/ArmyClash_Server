/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import estructuras.arbolBinario.Arbol;
import estructuras.listaDobleCircular.ListaDobleCircular;
import estructuras.matrizDispersa.Matriz;
import java.util.Scanner;
import rabbit.Enviar;
import sistema.bean.Tropa;
import sistema.ui.VentanaConfiguracion;

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
    
    public static ListaDobleCircular capas = new ListaDobleCircular();
    public static Arbol arbolJugador1 = new Arbol();
    public static Arbol arbolJugador2 = new Arbol();
    
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

//        Arbol arbol = new Arbol();
//        arbol.insertar(new Tropa(50));
//        arbol.insertar(new Tropa(25));
//        arbol.insertar(new Tropa(75));
//        arbol.insertar(new Tropa(15));
//        arbol.insertar(new Tropa(35));
//        arbol.insertar(new Tropa(65));
//        arbol.insertar(new Tropa(100));
//        arbol.insertar(new Tropa(10));
//        arbol.insertar(new Tropa(20));
//        arbol.insertar(new Tropa(30));
//        arbol.insertar(new Tropa(40));
//        arbol.insertar(new Tropa(60));
//        arbol.insertar(new Tropa(70));
//        arbol.insertar(new Tropa(80));
//        arbol.insertar(new Tropa(110));
//        arbol.inorden();
//        System.out.println();
//        //arbol.preorden();
//        System.out.println();
//        //arbol.postorden();
//        System.out.println();
//        arbol.eliminar(10);
//        arbol.inorden();
//        System.out.println();
//        //arbol.preorden();
//        System.out.println();
//        //arbol.postorden();
//        System.out.println();
//        
//        arbol.eliminar(110);
//        arbol.inorden();
//        System.out.println();
//        
//        arbol.eliminar(100);
//        arbol.inorden();
//        System.out.println();
//        arbol.eliminar(15);
//        arbol.inorden();
//        System.out.println();
//        arbol.eliminar(40);
//        arbol.inorden();
//        System.out.println();
//        arbol.eliminar(60);
//        arbol.inorden();
//        System.out.println();
//        arbol.eliminar(25);
//        arbol.inorden();
//        System.out.println();
//        arbol.eliminar(75);
//        arbol.inorden();
//        System.out.println();
//        arbol.eliminar(70);
//        arbol.inorden();
//        System.out.println();
//        arbol.eliminar(30);
//        arbol.inorden();  
//        System.out.println();


//            Matriz matriz = new Matriz();
//            matriz.mostrarCelda(10, 10);
//            if(matriz.existeFila(0))
//                System.out.println("existe");
//            matriz.mostrarFilas();
//            matriz.agregarFila(10);
//            matriz.mostrarFilas();
//            matriz.agregarFila(2);
//            matriz.mostrarFilas();
//            matriz.agregarFila(15);
//            matriz.mostrarFilas();
//            matriz.agregarFila(1);
//            matriz.mostrarFilas();
//            if(matriz.existeFila(10))
//                System.out.println("existe");
//            
//            if(matriz.existeColumna(0))
//                System.out.println("existe");
//            matriz.mostrarColumnas();
//            matriz.agregarColumna(2);
//            matriz.mostrarColumnas();
//            matriz.agregarColumna(1);
//            matriz.mostrarColumnas();
//            matriz.agregarColumna(10);
//            matriz.mostrarColumnas();
//            matriz.agregarColumna(5);
//            matriz.mostrarColumnas();
//            matriz.agregarColumna(4);
//            matriz.mostrarColumnas();
//            matriz.agregarColumna(11);
//            matriz.mostrarColumnas();
//            if(matriz.existeColumna(11))
//                System.out.println("existe");
//            
//            matriz.insertarCelda(1, 1, 1);
//            matriz.insertarCelda(2, 10, 10);
//            matriz.insertarCelda(3, 10, 15);
//            matriz.insertarCelda(4, 11, 1);
//            matriz.insertarCelda(5, 11, 2);
//            matriz.mostrarCelda(1, 1);
//            matriz.mostrarCelda(10, 10);
//            matriz.mostrarCelda(10, 15);
//            matriz.mostrarCelda(11, 1);
//            matriz.mostrarCelda(11, 2);

            VentanaConfiguracion configuracion = new VentanaConfiguracion();
            
    }
}
