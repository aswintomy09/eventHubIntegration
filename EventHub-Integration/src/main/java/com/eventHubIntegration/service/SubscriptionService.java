package com.eventHubIntegration.service;

import com.eventHubIntegration.exception.AlreadySubscribedException;
import com.eventHubIntegration.model.Subscription;

public interface SubscriptionService {

	Subscription subscribe(Subscription subscription)  throws AlreadySubscribedException;

}
