package com.eventHubIntegration.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class Event {
	
	@NonNull
	private String eventType;
	
	private Object eventData;

}
