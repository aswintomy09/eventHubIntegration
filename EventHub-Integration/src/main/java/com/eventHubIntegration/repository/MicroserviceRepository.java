package com.eventHubIntegration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventHubIntegration.model.Microservice;

@Repository
public interface MicroserviceRepository extends JpaRepository<Microservice, Long> {

	Microservice getSubscribedMicroservicesByTopic(String topic);

}
