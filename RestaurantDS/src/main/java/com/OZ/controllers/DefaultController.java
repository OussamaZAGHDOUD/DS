package com.OZ.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

	@RequestMapping({"/","/index"})
	public String hello() {
		return "<h1>hello world ! </h1>";
	}
}
