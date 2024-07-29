package com.example.boot11.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String home(Model m2) {
		
		List<Integer> sale = Arrays.asList(100,200,300);
		m2.addAttribute("sale", sale);
		return "home";
	}
}
