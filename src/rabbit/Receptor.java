/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import sistema.archivos.Archivo;

/**
 *
 * @author bruno
 */
public class Receptor extends Thread{

    @Override
    public void run() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try{
            Connection conexion = factory.newConnection();
            Channel canal = conexion.createChannel();
            canal.queueDeclare("ArmyClash-Peticiones", false, false, false, null);
            DeliverCallback deliverCallback = (consumerTag, delivery) ->{
                String mensaje = new String(delivery.getBody(), "UTF-8");
                manejarMensajes(mensaje);
            };
            canal.basicConsume("", true, deliverCallback, consumerTag -> {});
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void manejarMensajes(String mensaje){
        try{
            String[] contenido = mensaje.split("<");   
            switch(contenido[1]){
                case "0"://no solicita respuesta
                    String[] cuerpoMensaje = contenido[0].split(">");
                    Archivo archivo;
                    String[] valoresJ2, valoresJ1;
                    switch(cuerpoMensaje[1]){
                        case "t1":
                            archivo = new Archivo();
                            archivo.cargarTropasCliente(cuerpoMensaje[0], Integer.parseInt(cuerpoMensaje[1].substring(1)));   
                            break;
                        case "t2":
                            archivo = new Archivo();
                            archivo.cargarTropasCliente(cuerpoMensaje[0], Integer.parseInt(cuerpoMensaje[1].substring(1)));   
                            break;
                        case "ac1":
                            sistema.ui.VentanaConfiguracion.txtLog.append("---> Guardando movimiento jugador 1\n");
                            valoresJ1 = cuerpoMensaje[0].split(",");
                            main.Main.arbolJugador1.modificarNodo(Integer.parseInt(valoresJ1[0]), Integer.parseInt(valoresJ1[1]), Integer.parseInt(valoresJ1[2]), Double.parseDouble(valoresJ1[3]));
                            break;
                        case "ac2":
                            sistema.ui.VentanaConfiguracion.txtLog.append("---> Guardando movimiento jugador 2\n");
                            valoresJ2 = cuerpoMensaje[0].split(",");
                            main.Main.arbolJugador2.modificarNodo(Integer.parseInt(valoresJ2[0]), Integer.parseInt(valoresJ2[1]), Integer.parseInt(valoresJ2[2]), Double.parseDouble(valoresJ2[3]));
                            
                            break;
                        case "atq1":
                            sistema.ui.VentanaConfiguracion.txtLog.append("---> Guardando ataque a jugador 1\n");
                            valoresJ1 = cuerpoMensaje[0].split(",");
                            main.Main.arbolJugador1.modificarNodo(Integer.parseInt(valoresJ1[0]), Integer.parseInt(valoresJ1[1]), Integer.parseInt(valoresJ1[2]), Double.parseDouble(valoresJ1[3]));
                            break;
                        case "atq2":
                            sistema.ui.VentanaConfiguracion.txtLog.append("---> Guardando ataque sa jugador 2\n");
                            valoresJ2 = cuerpoMensaje[0].split(",");
                            main.Main.arbolJugador2.modificarNodo(Integer.parseInt(valoresJ2[0]), Integer.parseInt(valoresJ2[1]), Integer.parseInt(valoresJ2[2]), Double.parseDouble(valoresJ2[3]));
                            break;
                        case "mrt1":
                            sistema.ui.VentanaConfiguracion.txtLog.append("---> Guardando muerte de tropa jugador 1...\n---> Eliminanado nodo del Arbol...\n");
                            main.Main.arbolJugador1.eliminar(Integer.parseInt(cuerpoMensaje[0]));
                            break;
                        case "mrt2":
                            sistema.ui.VentanaConfiguracion.txtLog.append("---> Guardando muerte de tropa jugador 2...\n---> Eliminanado nodo del Arbol...\n");
                            main.Main.arbolJugador2.eliminar(Integer.parseInt(cuerpoMensaje[0]));
                            break;
                        case "cc":
                            sistema.ui.VentanaConfiguracion.txtLog.append("---> Aumentando Contador en celda...\n");
                            String coordenadas[] = cuerpoMensaje[0].split(",");
                            main.Main.capas.aumentarContadorCeldaCapa(Integer.parseInt(coordenadas[0]), Integer.parseInt(coordenadas[1]), Integer.parseInt(coordenadas[2]));
                            break;
                        case "pf":
                            sistema.ui.VentanaConfiguracion.txtLog.append("---> Partida Finalizada, Eliminando Arboles y Reiniciando Mapa....\n");
                            main.Main.arbolJugador1 = null;
                            main.Main.arbolJugador2 = null;
                            main.Main.capas.reiniciarContadoresCapas();
                            break;
                    }
                    break;
                case "1"://solicita respuesta
                    switch(contenido[0]){
                        case "mapa":
                            sistema.ui.VentanaConfiguracion.txtLog.setText(sistema.ui.VentanaConfiguracion.txtLog.getText()+ "Peticion: MAPA De: Cliente\n----> Agregando a Cola...\n");
                            main.Main.peticiones.insertar("mapa"); 
                            break;
                        case "tropas":
                            sistema.ui.VentanaConfiguracion.txtLog.setText(sistema.ui.VentanaConfiguracion.txtLog.getText()+ "Peticion: TROPAS De: Cliente\n----> Agregando a Cola...\n");
                            main.Main.peticiones.insertar("tropas"); 
                            break;
                        default:
                            sistema.ui.VentanaConfiguracion.txtLog.setText(sistema.ui.VentanaConfiguracion.txtLog.getText()+ "Peticion:DESCONOCIDA De: Cliente\n----> Imposible responder...\n");
                    }
                    break;
            }
        }catch(Exception ex){}
    }
}
