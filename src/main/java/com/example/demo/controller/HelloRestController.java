package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;

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
	
//	curl -X POST -H "Content-Type: application/json"
//		 -d '{"firstName": "Krishna","lastName": "Nimmanagoti"}'
//		 "http://localhost:8080/hello/post" -w "\n"
	@PostMapping("/post")
	public String sayHello(@RequestBody User user) {
		return "Hello" + user.getFirstName() + " "  + user.getLastName() + "!";
	}
	
//	curl -X PUT localhost:8080/hello/put/Krishna/?lastName=Nimmanagoti -w "\n"
	@PutMapping("/put/{firstName}")
	public String sayHello(@PathVariable String firstName,
						   @RequestParam(value = "lastName") String lastName) {
		return "Hello " + firstName + " " + lastName + "!";
	}
}
