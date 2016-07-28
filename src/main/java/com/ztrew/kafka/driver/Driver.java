package com.ztrew.kafka.driver;

import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.log4j.Logger;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

public class Driver {

	private static Logger logger = Logger.getLogger(Driver.class);

	public static void main(String[] args) {

		logger.info(Driver.class);

		long events = Long.parseLong(args[0]);
		Random rnd = new Random();

		Properties props = new Properties();
		props.put("metadata.broker.list",
				"cdh-test-data-01.ztrew.com:9092,cdh-test-data-02.ztrew.com:9092,cdh-test-data-03.ztrew.com:9092,cdh-test-data-04.ztrew.com:9092,cdh-test-data-05.ztrew.com:9092,cdh-test-data-06.ztrew.com:9092");
		props.put("serializer.class", "kafka.serializer.StringEncoder");
		props.put("partitioner.class", "com.ztrew.kafka.partitioner.SimplePartitioner");
		props.put("request.required.acks", "1");

		ProducerConfig config = new ProducerConfig(props);

		Producer<String, String> producer = new Producer<String, String>(config);

		for (long nEvents = 0; nEvents < events; nEvents++) {
			long runtime = new Date().getTime();
			String ip = "192.168.2." + rnd.nextInt(255);
			String msg = runtime + ",www.example.com," + ip;
			KeyedMessage<String, String> data = new KeyedMessage<String, String>("page_visits", ip, msg);
			logger.info("{page_visits}, {" + ip + "}, {" + msg + "}");
			producer.send(data);
		}

		producer.close();

	}

}
