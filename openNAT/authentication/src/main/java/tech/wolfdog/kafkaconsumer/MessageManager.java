package tech.wolfdog.kafkaconsumer;

import org.apache.kafka.clients.consumer.ConsumerRecords;
/*This is the Manager of the Authentication module*/
public class MessageManager {
	public static void main(String [] args) {
		AuthenticationMQConsumer mqConsumer = new AuthenticationMQConsumer();
		mqConsumer.getHTTPfromMQ();
		ConsumerRecords<String, String> records = null;
		while((records = mqConsumer.getObserver().getRecords())!=null) {
			new WebServiceContactor().contactWebService(records);
		}
	}
}
