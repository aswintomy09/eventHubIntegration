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

    public Subscription subscribe(String topic, Subscription subscription) {
        // Check if microservice is already subscribed to the topic
        if (subscriptionRepository.existsByMicroserviceIdAndTopic(subscription.getMicroserviceId(), topic)) {
            throw new AlreadySubscribedException("Microservice is already subscribed to the topic");
        }

        // Perform any necessary operations or validations on the subscription
        // ...

        // Subscribe the microservice to the topic in the message broker
        messageBrokerClient.subscribeToTopic(topic, subscription.getMicroserviceId());

        // Save the subscription
        subscription.setTopic(topic);
        subscriptionRepository.save(subscription);

        return subscription;
    }
}
