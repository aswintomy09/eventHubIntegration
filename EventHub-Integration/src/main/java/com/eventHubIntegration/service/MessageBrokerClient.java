package com.eventHubIntegration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.eventHubIntegration.model.Event;
import com.eventHubIntegration.model.Subscription;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MessageBrokerClient {
	
	@Autowired
    private KafkaTemplate<String, Event> kafkaTemplateEvent;
	
	@Autowired
    private KafkaTemplate<String, Subscription> kafkaTemplateSubscription;
    
    // Add necessary dependencies for interacting with the message broker
    // e.g., RabbitTemplate for RabbitMQ or KafkaTemplate for Apache Kafka

    public void publishEvent(String topic, Event event) {
        try {
            // Convert the event to a message format supported by the message broker
            Message<Event> message = createMessage(event);
            
            // Publish the message to the specified topic in the message broker
            sendMessage(topic, message);

            log.info("Event published to topic: {}", topic);

        } catch (Exception e) {
            log.error("Failed to publish event to topic: {}", topic, e);
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
    	kafkaTemplateEvent.send(topic, event);
    }

	public void subscribeToTopic(String topic, Long microserviceId) {
		 Subscription subscription = new Subscription();
		 subscription.setMicroserviceId(microserviceId);
		 subscription.setTopic(topic);

	        // Publish the subscription to the Kafka topic
		 kafkaTemplateSubscription.send(topic, subscription);
		 log.info("Subscribed microservice with ID {} to topic {}", microserviceId, topic);
	}
}
