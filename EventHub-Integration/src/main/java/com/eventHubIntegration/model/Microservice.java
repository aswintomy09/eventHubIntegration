package com.eventHubIntegration.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "Microservice")
public class Microservice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "Service_name")
	private String serviceName;
	
	@Column(name = "Topic")
	private String topic;
	
	@Column(name = "Endpoint")
	private String communicationEndpoint;

}
