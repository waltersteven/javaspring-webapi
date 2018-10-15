package com.coding.springbootapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("index")
	public String index() {
		System.out.println("hi, walter");
		return "index.jsp";
	}
}
