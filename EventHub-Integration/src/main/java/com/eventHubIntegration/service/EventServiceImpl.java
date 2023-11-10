package com.eventHubIntegration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventHubIntegration.model.Event;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
    private MessageBrokerClient messageBrokerClient;

    public Event publishEvent(String topic, Event event) {
        // Perform any necessary operations or validations on the event
        
        // Publish the event to the message broker
        messageBrokerClient.publishEvent(topic, event);
        
        return event;
    }

}
