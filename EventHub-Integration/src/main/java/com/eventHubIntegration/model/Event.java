package com.eventHubIntegration.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class Event {
	
	@NonNull
	private String eventType;
	
	private Object eventData;

}
