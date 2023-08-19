package br.com.erudio.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.model.Greeting;

@RestController

public class GreetingController {

	private final AtomicLong counter = new AtomicLong();
	private static final String template = "Hello, %s!";
	
	@RequestMapping("/greeting")
	public Greeting greeting(
			@RequestParam(value = "name", defaultValue = "World") String name) {
		
		return new Greeting(counter.getAndIncrement(), String.format(template, name));
	}
}
