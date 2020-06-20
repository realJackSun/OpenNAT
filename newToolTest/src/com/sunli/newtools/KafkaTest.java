package tech.wolfdog.kafkaproducer;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.clients.producer.internals.DefaultPartitioner;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.HashMap;
import java.util.Map;
/**
 * {@code DispatcherMQProducer} writes HTTP message into the MQ.
 *
 * @author Li Sun (sjtusl@163.com)
 */
public class KafkaTest {
	/**
     * Returns {@code true} if this task completed.
     *
     * Completion may be due to normal termination, an exception, or
     * cancellation -- in all of these cases, this method will return
     * {@code true}.
     *
     * @return {@code true} if this task completed
     */
	public boolean saveHTTPtoMQ (String topic,String key,String httpBody){
		ThreadLocal<Boolean> sendSuccess = new ThreadLocal<Boolean>();
		sendSuccess.set(true);
		Map<String, Object> props = new HashMap<String, Object>();
		props.put("bootstrap.servers", "localhost:9092");
		//System.out.println(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		//props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		//props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
		props.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, DefaultPartitioner.class.getName());
		Producer<String, String> producer = new org.apache.kafka.clients.producer.KafkaProducer<String, String>(props);
		producer.send(new ProducerRecord<String, String>(topic, key, httpBody)
    		   ,(RecordMetadata metadata,Exception exception)->{
    			   System.out.println("Sending message...");
    			   if(exception == null) {
    				   System.out.println("I have send the message");
    				   sendSuccess.set(new Boolean(true));
    			   }else {
    				   sendSuccess.set(false);
    			   }
    	   
    		   });
		producer.close();
		return sendSuccess.get();
	}
	public static void main(String [] args) {
		System.out.println(new DispatcherMQProducer().saveHTTPtoMQ("test","test-key", "{User-agent:chrome}"));
	}
}
