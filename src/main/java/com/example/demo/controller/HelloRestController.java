package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloRestController {
	
//	curl localhost:8080/hello -w "\n"
	@RequestMapping(value = {"", "/", "/home"})
	public String sayHello() {
		return "Hello From Bridgelabz!!!";
	}
	
//	curl localhost:8080/hello/query?name=Krishna -w "\n"
	@RequestMapping(value = {"/query"}, method = RequestMethod.GET)
	public String sayHello(@RequestParam(value = "name") String name) {
		return "Hello" + name + "!";
	}
	
//	curl localhost:8080/hello/param/Krishna -w "\n"
	@GetMapping("/param/{name}")
	public String sayHelloParam(@PathVariable String name) {
		return "Hello" + name + "!";
	}
}
