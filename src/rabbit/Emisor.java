/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 *
 * @author bruno
 */
public class Emisor {
    
    public void enviarPeticion(String respuesta){
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try {
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare("ArmyClash-Respuestas", false, false, false, null);
            channel.basicPublish("", "ArmyClash-Respuestas", null, respuesta.getBytes());
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
