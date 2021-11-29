package com.project.payments;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Hello {
	
	@RequestMapping("/hello")
	public String jello() {
		return "hello world!!!";
	}
	
}

