/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import estructuras.arbolBinario.Arbol;
import estructuras.cola.Cola;
import estructuras.listaDobleCircular.ListaDobleCircular;
import rabbit.AdministradorRespuestas;
import rabbit.Receptor;
import sistema.ui.VentanaConfiguracion;

/**
 *
 * @author bruno
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    //SERVIDOR
    
    public static ListaDobleCircular capas = new ListaDobleCircular();
    public static Arbol arbolJugador1;
    public static Arbol arbolJugador2;
    
    public static Cola peticiones = new Cola();
    
    public static void main(String[] args) throws Exception{
        Receptor receptor = new Receptor();
        receptor.start();
        VentanaConfiguracion configuracion = new VentanaConfiguracion();        
        AdministradorRespuestas administradorRespuestas = new AdministradorRespuestas();
        administradorRespuestas.start();
    }
}
