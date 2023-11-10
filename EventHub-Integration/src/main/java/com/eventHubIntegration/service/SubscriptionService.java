package com.eventHubIntegration.service;

import com.eventHubIntegration.model.Subscription;

public interface SubscriptionService {

	Subscription subscribe(String topic, Subscription subscription);

}
