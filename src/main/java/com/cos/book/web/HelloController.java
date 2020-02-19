package com.cos.book.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cos.book.web.dto.HelloResponseDto;

@RestController
public class HelloController {
	
	
	private static final Logger log = LoggerFactory.getLogger(HelloController.class);

	
	@GetMapping("/hello")
	public String hello() {
		log.info("hello");
		return "hello";
	}
	
	@GetMapping("/hello/dto")
	public HelloResponseDto helloDto(
			@RequestParam("name") String name, @RequestParam("amount") int amount) {
		log.info("helloDto");
		return new HelloResponseDto(name, amount);
	}
}
