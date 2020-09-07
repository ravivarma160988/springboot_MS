package com.wipro.student.service;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ConfigApp {
	
	@Bean
	@Scope("prototype")
	public String getSessionBean() {
		return "session bean created "+LocalDateTime.now();
	}
	
	@Bean
	@Scope("request")
	public String getRequestBean() {
		return "request bean created "+LocalDateTime.now();
	}

}
