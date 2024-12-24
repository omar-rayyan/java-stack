package com.axsosacademy.firstspringproject.mvc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	@RequestMapping("/")
	public String root() {
		return "Hello World!";
	}
}
