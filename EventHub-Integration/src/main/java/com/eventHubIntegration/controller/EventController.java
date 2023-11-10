package com.eventHubIntegration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@PostMapping("/{topic}")
    public ResponseEntity<Event> publishEvent(@PathVariable("topic") String topic, @RequestBody Event event) {
        Event publishedEvent = eventService.publishEvent(topic, event);
        return ResponseEntity.ok(publishedEvent);
    }
	
}
