package com.eventHubIntegration.service;

import static com.eventHubIntegration.util.Constants.MICROSERVICE_REGISTRATION_FAILED;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventHubIntegration.exception.MicroserviceRegistrationException;
import com.eventHubIntegration.model.Microservice;
import com.eventHubIntegration.model.MicroserviceDetails;
import com.eventHubIntegration.repository.MicroserviceRepository;

@Service
public class MicroserviceServiceImpl implements MicroserviceService {
	
	@Autowired
    private MicroserviceRepository microserviceRepository;
    
	@Override
	public Long registerMicroservice(MicroserviceDetails microserviceDetails) throws MicroserviceRegistrationException {
		try {
		Microservice microservice = new Microservice();
        microservice.setServiceName(microserviceDetails.getServiceName());
        microservice.setTopics(microserviceDetails.getTopics());
        microservice.setCommunicationEndpoint(microserviceDetails.getCommunicationEndpoint());

        Microservice savedMicroservice = microserviceRepository.save(microservice);
        return savedMicroservice.getId();
		} catch (Exception e) {
            throw new MicroserviceRegistrationException(MICROSERVICE_REGISTRATION_FAILED, e);
        }
	}

}
