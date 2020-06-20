package tech.wolfdog.kafkaconsumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;


public class AuthenticationMQConsumer {
	private MessageObserver observer = new MessageObserver();
	
	public MessageObserver getObserver() {
		return observer;
	}

	public void getHTTPfromMQ() {
	       String topic = "test";
	       Properties props = new Properties();
	       props.put("bootstrap.servers", "localhost:9092");
	       props.put("group.id", "testGroup1");
	       props.put("enable.auto.commit", "true");
	       props.put("auto.commit.interval.ms", "1000");
	       props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	       props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	       Consumer<String, String> consumer = new KafkaConsumer(props);
	       consumer.subscribe(Arrays.asList(topic));
	       while (true) {
	    	   //Duration d = new Duration(0, 0);
	           @SuppressWarnings("deprecation")
	           ConsumerRecords<String, String> records = consumer.poll(100);
	           observer.setRecords(records);
	           //for (ConsumerRecord<String, String> record : records) {
	           		//System.out.printf("partition = %d, offset = %d, key = %s, value = %s%n", record.partition(), record.offset(), record.key(), record.value());
	           //}
	           
	           
	       }
	}
}
