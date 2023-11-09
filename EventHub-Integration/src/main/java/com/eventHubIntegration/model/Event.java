package com.eventHubIntegration.model;

import lombok.Data;

@Data
public class Event {
	
	private String eventType;
	
	private Object eventData;

}
