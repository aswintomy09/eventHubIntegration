package com.eventHubIntegration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventHubIntegration.exception.AlreadySubscribedException;
import com.eventHubIntegration.model.Subscription;
import com.eventHubIntegration.repository.SubscriptionRepository;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
	
	@Autowired
    private MessageBrokerClient messageBrokerClient;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public Subscription subscribe(Subscription subscription) throws AlreadySubscribedException {
        // Check if microservice is already subscribed to the topic
        if (subscriptionRepository.existsByMicroserviceIdAndTopic(subscription.getMicroserviceId(), subscription.getTopic())) {
            throw new AlreadySubscribedException("Microservice is already subscribed to the topic");
        }

        // Perform any necessary operations or validations on the subscription
        // ...

        // Subscribe the microservice to the topic in the message broker
        messageBrokerClient.subscribeToTopic(subscription.getTopic(), subscription.getMicroserviceId());

        // Save the subscription
        subscription.setTopic(subscription.getTopic());
        subscriptionRepository.save(subscription);

        return subscription;
    }
}
