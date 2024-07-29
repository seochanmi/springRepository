package com.example.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

	@GetMapping("/")
	public String web(Model model) {
		// Model 객체에 "weatherToday" 라는 키값으로 String type 담기
		model.addAttribute("weatherToday", "비옴");
		//여기서 리턴한 문자열 앞에는 /templates/ 가 붙고 뒤에는 .html 이 붙어서 /templates/home.html 을 가리키게 된다.
		return "web";
	}
}


