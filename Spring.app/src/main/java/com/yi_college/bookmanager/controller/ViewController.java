package com.yi_college.bookmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ViewController{
	
	@GetMapping("/books")
	public String books() {
		return "index";
		
		
	
	
	
	
	}

}
