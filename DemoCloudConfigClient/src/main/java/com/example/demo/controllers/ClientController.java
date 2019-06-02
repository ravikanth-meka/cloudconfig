package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.ConfigProp;

@RestController
@RequestMapping("app")
public class ClientController {
	
	@Autowired
	private ConfigProp configProp;
	
	@GetMapping
	public String getAppName() {
		
		return configProp.getAppname();
	}
}
