package com.OZ.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

	@RequestMapping({"/"})
	public String helloUser() {
		return "<h1>hello USER ! </h1>";
	}
	
	@RequestMapping({"/index"})
	public String helloAdmin() {
		return "<h1>hello ADMIN ! </h1>";
	}
}
