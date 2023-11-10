package com.eventHubIntegration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.eventHubIntegration.util.Constants.*;

import com.eventHubIntegration.exception.MicroserviceRegistrationException;
import com.eventHubIntegration.model.MicroserviceDetails;
import com.eventHubIntegration.service.MicroserviceService;

@RestController
@RequestMapping(MICROSERVICE_URL_PATH)
public class MicroserviceController {
	
	@Autowired
    private MicroserviceService microserviceService;

    @PostMapping("/register")
    public ResponseEntity<Long> registerMicroservice(@RequestBody MicroserviceDetails microserviceDetails) throws MicroserviceRegistrationException {
        Long microserviceId = microserviceService.registerMicroservice(microserviceDetails);
        return ResponseEntity.ok(microserviceId);
    }
}
