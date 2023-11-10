package com.eventHubIntegration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventHubIntegration.exception.AlreadySubscribedException;
import com.eventHubIntegration.model.Subscription;
import com.eventHubIntegration.service.SubscriptionService;

@RestController
@RequestMapping("/subscription")
public class SubscriptionController {
	
	@Autowired
    private SubscriptionService subscriptionService;

    @PostMapping("/{topic}")
    public ResponseEntity<Subscription> subscribe(@PathVariable("topic") String topic, @RequestBody Subscription subscription) throws AlreadySubscribedException {
        Subscription newSubscription = subscriptionService.subscribe(topic, subscription);
        return ResponseEntity.ok(newSubscription);
    }
}
