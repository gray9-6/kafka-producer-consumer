package com.example.kakfaproducerconsumer.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Before running this program, ensure the following prerequisites are met:
 * 1. Zookeeper is running:
 *    - Zookeeper is a centralized service used for maintaining configuration information, providing distributed synchronization, and naming.
 *    - Ensure Zookeeper is running and accessible by this application.
 *
 * 2. Kafka broker is running on localhost:
 *    - Kafka broker is the heart of the Kafka system, responsible for maintaining the published data in the topics and serving the consumers.
 *    - Ensure Kafka broker is running locally on the default port (usually 9092) and is reachable by this application.
 *
 * 3. The "fruits" topic is created:
 *    - Topics in Kafka are categories or feeds to which messages are published by producers and from which messages are consumed by consumers.
 *    - Make sure the topic "fruits" is created in Kafka with appropriate configurations such as replication factor, partitions, etc.
 */


/**
 * This class represents a Kafka message producer.
 * It sends messages to a Kafka topic named "fruits".
 */
@RestController
public class Producer {

    /**
     * Constructs a new Producer instance.
     *
     * @param kafkaTemplate The KafkaTemplate instance used for sending messages.
     */
    private KafkaTemplate kafkaTemplate;


    /**
     * Sends a message to the Kafka topic "fruits".
     *
     * @param message The message to be sent.
     */
    @GetMapping("/send")
    public void SendMessage(@RequestParam String message){
        kafkaTemplate.send("fruits",message);
    }
}


