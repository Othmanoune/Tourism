package com.ensa.controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	
	@GetMapping("")
	public @ResponseBody String home() {
		return "<h1 style='color:blue; font-size:30px;'>Connected to the backend of Tourism KAMOUNI & MOUSTATI.</h1>";
	}

	
}
