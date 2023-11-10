package com.eventHubIntegration.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.eventHubIntegration.model.Event;
import com.eventHubIntegration.model.Microservice;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MessageBrokerClient {
	
	@Autowired
    private KafkaTemplate<String, Event> kafkaTemplate;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MessageBrokerClient.class);
    
    // Add necessary dependencies for interacting with the message broker
    // e.g., RabbitTemplate for RabbitMQ or KafkaTemplate for Apache Kafka

    public void publishEvent(String topic, Event event) {
        try {
            // Convert the event to a message format supported by the message broker
            Message<Event> message = createMessage(event);
            
            // Publish the message to the specified topic in the message broker
            sendMessage(topic, message);

            LOGGER.info("Event published to topic: {}", topic);

        } catch (Exception e) {
            LOGGER.error("Failed to publish event to topic: {}", topic, e);
        }
    }

    private Message<Event> createMessage(Event event) {
        // Convert the event to a message format supported by the message broker
        // String eventPayload = convertEventToString(event);

        // Create a new Message with the event payload
        Message<Event> message = MessageBuilder
                .withPayload(event)
                .build();

        // Return the Message with the event payload
        return message;
    }

    private void sendMessage(String topic, Message<Event> message) {
    	Event event = message.getPayload();
        
        // Publish the event to the specified topic in the message broker using KafkaTemplate
        kafkaTemplate.send(topic, event);
    }
    
    @KafkaListener(topicPattern = "${message.broker.topic}")
    public void subscribeToTopic(Event event) {
        try {
            // Implement logic to subscribe the microservice to the specified topic in the message broker
            // KafkaListener annotations for message consumption
        	
            
        	 LOGGER.info("Received event: {}", event);

             // Process the event as needed
             // ...
             
         } catch (Exception e) {
             LOGGER.error("Failed to process event: {}", event, e);
        }
    }

	public void subscribeToTopic(String topic, Long microserviceId) {
		// TODO Auto-generated method stub
		
	}
}
