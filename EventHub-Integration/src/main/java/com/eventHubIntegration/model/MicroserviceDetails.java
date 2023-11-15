package com.eventHubIntegration.model;

import lombok.Data;

@Data
public class MicroserviceDetails {
	
	private String serviceName;
	
    private String topic;
    
    private String communicationEndpoint;
    
}
