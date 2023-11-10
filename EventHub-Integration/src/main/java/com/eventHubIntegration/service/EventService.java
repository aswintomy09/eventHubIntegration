package com.eventHubIntegration.service;

import com.eventHubIntegration.model.Event;

public interface EventService {

	Event publishEvent(String topic, Event event);

}
