package com.bharath.location.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloworldController {

	
	@RequestMapping("/index")
	public String openPage() {
		System.out.println("Entering in controller");
		return "index";
	}
	
	@RequestMapping("/mov")
	public String openMov() {
		System.out.println("Entering in controller");
		return "mov";
	}
}
