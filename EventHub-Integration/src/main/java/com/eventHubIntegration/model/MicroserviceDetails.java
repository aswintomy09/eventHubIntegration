package com.eventHubIntegration.model;

import java.util.List;

import lombok.Data;

@Data
public class MicroserviceDetails {
	
	private String serviceName;
	
    private List<String> topics;
    
    private String communicationEndpoint;
    
}
