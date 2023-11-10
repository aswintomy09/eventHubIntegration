package com.eventHubIntegration.model;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Subscription {
	
	private Long microserviceId;

    private String topic;
	
}
