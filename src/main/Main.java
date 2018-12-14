/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

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
        ListaDobleCircular listaDobleCircular = new ListaDobleCircular();
        listaDobleCircular.insertar(10);
        listaDobleCircular.mostrar();
        listaDobleCircular.mostrarInverso();
        listaDobleCircular.insertar(20);
        listaDobleCircular.mostrar();
        listaDobleCircular.mostrarInverso();
        listaDobleCircular.insertar(30);
        listaDobleCircular.mostrar();
        listaDobleCircular.mostrarInverso();
        listaDobleCircular.insertar(40);
        listaDobleCircular.mostrar();
        listaDobleCircular.mostrarInverso();
        listaDobleCircular.insertar(50);
        listaDobleCircular.mostrar();
        listaDobleCircular.mostrarInverso();
    }
}
