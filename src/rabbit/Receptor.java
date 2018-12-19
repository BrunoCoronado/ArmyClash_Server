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
            if(mensaje.contains("<")){
                String[] contenido = mensaje.split("<");//la posicion 0 contendria el cuerpo del mensaje y la parte la accion a tomar   
                switch(contenido[1]){
                    case "0":
                        Archivo archivo = new Archivo();
                        archivo.cargarTropas(contenido[0]);
                        break;
                }
            }else{
                main.Main.peticiones.insertar(mensaje); 
                main.Main.peticiones.mostrar();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
