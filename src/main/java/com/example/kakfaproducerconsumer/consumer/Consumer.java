package com.example.kakfaproducerconsumer.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * This class represents a Kafka message consumer.
 * It listens for messages from a Kafka topic named "fruits".
 */
@Service
public class Consumer {

    /**
     * Listens for messages from the Kafka topic "fruits".
     *
     * @param message The message consumed from the Kafka topic.
     */
    @KafkaListener(topics = {"fruits"}, groupId = "abc")
    public void consumeMessage(String message){
        System.out.println(message);
    }
}
