package com.eventHubIntegration.service;

import com.eventHubIntegration.exception.MicroserviceRegistrationException;
import com.eventHubIntegration.model.Microservice;
import com.eventHubIntegration.model.MicroserviceDetails;

public interface MicroserviceService {

	Microservice registerMicroservice(MicroserviceDetails microserviceDetails) throws MicroserviceRegistrationException;

	String getSubscribedMicroservices(String topic);

}
