package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class WelcomController {
	
	 @GetMapping("/welcome")
	 public String  all() {
	    return "Welcome";
	  }

}
