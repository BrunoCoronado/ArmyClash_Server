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
                main.Main.peticiones.insertar(new String(delivery.getBody(), "UTF-8")); 
                main.Main.peticiones.mostrar();
            };
            canal.basicConsume("", true, deliverCallback, consumerTag -> {});
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
