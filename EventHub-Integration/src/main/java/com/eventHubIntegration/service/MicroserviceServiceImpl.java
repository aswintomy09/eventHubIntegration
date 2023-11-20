package com.eventHubIntegration.service;

import static com.eventHubIntegration.util.Constants.MICROSERVICE_REGISTRATION_FAILED;

import java.util.HashMap;
import java.util.Map;

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
	
	private final Map<String, String> subscribedTopics = new HashMap<>();
    
	@Override
	public Microservice registerMicroservice(MicroserviceDetails microserviceDetails) throws MicroserviceRegistrationException {
		try {
		Microservice microservice = new Microservice();
        microservice.setServiceName(microserviceDetails.getServiceName());
        microservice.setTopic(microserviceDetails.getTopic());
        microservice.setCommunicationEndpoint(microserviceDetails.getCommunicationEndpoint());

        Microservice savedMicroservice = microserviceRepository.save(microservice);
        return savedMicroservice;
		} catch (Exception e) {
            throw new MicroserviceRegistrationException(MICROSERVICE_REGISTRATION_FAILED, e);
        }
	}
	
	public Microservice getSubscribedMicroservices(String topic) {
        return microserviceRepository.getSubscribedMicroservicesByTopic(topic);
    }

}
