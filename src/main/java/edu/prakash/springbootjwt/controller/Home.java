package edu.prakash.springbootjwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {
	@GetMapping(name = "/")
	public String welcome() {
		return "Unauthorized user!";
	}

}
