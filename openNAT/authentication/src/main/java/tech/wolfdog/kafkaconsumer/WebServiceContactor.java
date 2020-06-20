package tech.wolfdog.kafkaconsumer;

import org.apache.kafka.clients.consumer.ConsumerRecords;
/*This class contact the WebService*/
public class WebServiceContactor {
	public boolean contactWebService(ConsumerRecords<String,String> recores) {
		return true;
	}
}
