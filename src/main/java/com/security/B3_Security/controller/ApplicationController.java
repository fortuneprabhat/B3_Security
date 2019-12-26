package com.security.B3_Security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {
	
	@RequestMapping(method = RequestMethod.GET, path = "/")
	public String home() {
		return "<h1>Root Page<h1>";
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/admin")
	public String admin() {
		return "welcome admin";
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/user")
	public String user() {
		return "<h1>welcome user<h1>";
	}
}
