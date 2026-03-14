package com.sistema.banco.producer;
import com.sistema.banco.config.MyServerRabbit;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;
import com.sistema.banco.modelos.LoteTransacciones;
import com.sistema.banco.modelos.Transaccion;
import com.sistema.banco.servicios.BankApiService;

public class Productor {
	public static void main(String[] args) {
		ConnectionFactory factory = MyServerRabbit.getFactory();

        ObjectMapper mapper = new ObjectMapper();

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
        	System.out.println("Producer iniciado. Conectado a RabbitMQ como Lester.");
            
  
                LoteTransacciones lote = BankApiService.obtenerTransacciones();
                System.out.println("Status del GET: 200 OK");

                for (Transaccion tx : lote.getTransacciones()) {
            	String bank = tx.getBancoDestino().toUpperCase().trim();
                
                channel.queueDeclare(bank, true, false, false, null);

                String payload = mapper.writeValueAsString(tx);
                
                channel.basicPublish("", bank, MessageProperties.PERSISTENT_TEXT_PLAIN, payload.getBytes());

                System.out.println("Paublicada transacción " + tx.getIdTransaccion() + " en cola: " + bank);
            }

            System.out.println("Proceso terminado. Lote enviado.");
          

        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }

}
