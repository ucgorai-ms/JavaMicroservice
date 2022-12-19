package com.practice.microservice.limitservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.microservice.limitservice.bean.Limit;
import com.practice.microservice.limitservice.configuration.Configuration;

@RestController
public class LimitController {
	
	@Autowired
	private Configuration configuration;
	
	@GetMapping(path = "/limits")
	public Limit getLimits () {
		
		return new Limit(configuration.getMinimum(), configuration.getMaximum());
	}

}
