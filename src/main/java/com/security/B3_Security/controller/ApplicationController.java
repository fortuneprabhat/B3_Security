package com.security.B3_Security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {
	
	@RequestMapping(method = RequestMethod.GET, path = "/")
	public String home() {
		return "Root Page";
	}
}
