package com.eventHubIntegration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventHubIntegration.model.Subscription;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

	boolean existsByMicroserviceIdAndTopic(Long microserviceId, String topic);

}
