/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rabbit;

import javax.swing.Timer;

/**
 *
 * @author bruno
 */
public class AdministradorRespuestas extends Thread{
    Timer timer;
    Emisor emisor = new Emisor();
    
    @Override
    public void run() {
       timer = new Timer(2000, (ae) -> {
           if(!main.Main.peticiones.vacio()){
               String peticion = main.Main.peticiones.cola().toString();
               main.Main.peticiones.remover();
               emisor.enviarPeticion(manejarPeticion(peticion));
           }
       });
       timer.start();
        System.out.println("Administrador de respuestas activo");
    }
    
    private String  manejarPeticion(String peticion){
        switch(peticion){
            case "mapa": return "MAPA";
            case "jugador1": return "JUGADOR1";
            case "jugador2": return "JUGADOR2";
        }
        return "";
    }
}
