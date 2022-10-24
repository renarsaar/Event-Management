package com.example.EventManagement;

import com.example.EventManagement.common.EventPublisher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class EventManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventManagementApplication.class, args);
	}

	@Bean
	EventPublisher eventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		return applicationEventPublisher::publishEvent;
	}
}
