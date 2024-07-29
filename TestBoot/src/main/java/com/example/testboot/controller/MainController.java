package com.example.testboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.testboot.dto.MemberDto;



@Controller
public class MainController {
	
	@ResponseBody
	@GetMapping("/member")
	public Map<String, Object> member(){
		Map<String, Object> map=new HashMap<>();
		map.put("num", 1);
		map.put("name", "김구라");
		map.put("isMan", true);
		
		return map;
	
}
	@ResponseBody
	@GetMapping("/member2")
	public MemberDto member2() {
		MemberDto dto= new MemberDto();
		dto.setNum(1);
		dto.setName("김구라");
		dto.setAddr("노량진");
		return dto;
	}
	
	@GetMapping("/hihi")
	@ResponseBody
	public String hihi() {
		
		return "hihi";
	}
	
	@GetMapping("/weather")
	@ResponseBody
	public String weather() {
		
		return "오늘의 날씨는 비가 계속 와요";
	}
}
