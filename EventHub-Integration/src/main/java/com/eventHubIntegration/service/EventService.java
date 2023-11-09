package com.eventHubIntegration.service;

import com.eventHubIntegration.model.Event;

public interface EventService {

	void publishEvent(Event event);

}
