package com.eventHubIntegration.service;

import com.eventHubIntegration.exception.MicroserviceRegistrationException;
import com.eventHubIntegration.model.MicroserviceDetails;

public interface MicroserviceService {

	Long registerMicroservice(MicroserviceDetails microserviceDetails) throws MicroserviceRegistrationException;

}
