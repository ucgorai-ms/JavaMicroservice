package com.practice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practice.bean.HelloWorldBean;

@RestController
public class HelloWorldController {

	@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
	public String getHelloWorld() {
		
		return "Hello World From Rest Controller!!";
	}
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean getHelloWorldBean() {
		
		return new HelloWorldBean("Hello world bean from Rest controller!!");
		
	}
	
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean getHelloWorldBeanPathVariable(@PathVariable String name) {
		
		return new HelloWorldBean(String.format("Hello %s, Welcome to this project!!", name));
		
	}

}
