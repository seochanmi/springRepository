package com.example.testboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class SubmitController {
	/*
	 * 	컨트롤러 메소드 안에서 HttpServletRequest, HttpServletResponse, HttpSession 등의 객체가 필요하면
	 * 	매개변수에 선언하면 된다.
	 * 
	 * 	선언만 하면 spring 프레임워크가 알아서 해당객체의 참조값을 매개변수에 전달해준다.
	 */
	@ResponseBody
	@PostMapping("/submit")
	public String submit(HttpServletRequest request) {
		//요청 파라미터 추출하기
		String msg=request.getParameter("msg");
		System.out.println("msg:"+msg);
		
		return "/submit okay!";
	}
	
	@ResponseBody
	@PostMapping("/submit2")
	public String submit2(String msg) {
		System.out.println("msg:"+msg);
		return "/submit2 okay";
	}
}