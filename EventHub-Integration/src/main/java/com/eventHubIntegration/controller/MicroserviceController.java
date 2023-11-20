package com.eventHubIntegration.controller;

import static com.eventHubIntegration.util.Constants.MICROSERVICE_REGISTRATION_SUCCESS;
import static com.eventHubIntegration.util.Constants.MICROSERVICE_URL_PATH;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eventHubIntegration.exception.MicroserviceRegistrationException;
import com.eventHubIntegration.model.Microservice;
import com.eventHubIntegration.model.MicroserviceDetails;
import com.eventHubIntegration.service.MicroserviceService;

@RestController
@RequestMapping(MICROSERVICE_URL_PATH)
public class MicroserviceController {
	
	@Autowired
    private MicroserviceService microserviceService;

    @PostMapping("/register")
    public ResponseEntity<String> registerMicroservice(@RequestBody MicroserviceDetails microserviceDetails) throws MicroserviceRegistrationException {
        microserviceService.registerMicroservice(microserviceDetails);
        return ResponseEntity.ok(MICROSERVICE_REGISTRATION_SUCCESS);
    }
    
    @GetMapping("/list")
    public Microservice getSubscribedMicroservices(@RequestParam String topic) throws MicroserviceRegistrationException {
        Microservice subscribedMicroservice= microserviceService.getSubscribedMicroservices(topic);
        return subscribedMicroservice;
    }
}
