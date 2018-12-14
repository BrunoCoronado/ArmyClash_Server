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
public class Enviar{
    //SERVIDOR
    private final static String COLA = "pruebaHilo"; 
    
    public void enviarACola(String msg) throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection(); 
                Channel channel = connection.createChannel();){
            
            channel.queueDeclare(COLA, false, false, false, null);
            channel.basicPublish("", COLA, null, msg.getBytes());
            System.out.println("enviando: " +msg);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
