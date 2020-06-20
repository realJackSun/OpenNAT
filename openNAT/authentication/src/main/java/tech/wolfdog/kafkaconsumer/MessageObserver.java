package tech.wolfdog.kafkaconsumer;

import org.apache.kafka.clients.consumer.ConsumerRecords;
/*Observer design pattern*/
class MessageObserver {
	ConsumerRecords<String,String> records = null;

	public ConsumerRecords<String, String> getRecords() {
		return records;
	}

	public void setRecords(ConsumerRecords<String, String> records) {
		this.records = records;
	}
	
}
