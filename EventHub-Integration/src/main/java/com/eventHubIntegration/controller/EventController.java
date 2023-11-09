package com.eventHubIntegration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventHubIntegration.model.Event;
import com.eventHubIntegration.service.EventService;

import static com.eventHubIntegration.util.Constants.*;

@RestController
@RequestMapping(EVENT_URL_PATH)
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@PostMapping("/publish")
    public void publishEvent(@RequestBody Event event) {
        eventService.publishEvent(event);
    }
	
}
