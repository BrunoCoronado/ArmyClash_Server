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
                    Archivo archivo = new Archivo();
                    archivo.cargarTropas(contenido[0]);
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
        }catch(Exception ex){
            
        }
    }
}
