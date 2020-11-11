package com.svsbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonTest {
	
	@Autowired
	Environment environment;
	
	@GetMapping("/port")
	public String portDetails() {
		return "Running on port number : "+environment.getProperty("local.server.port");
	}
}
