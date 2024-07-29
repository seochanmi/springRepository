package com.example.boot05.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.boot05.dao.TodoDao;
import com.example.boot05.dto.MemberDto;
import com.example.boot05.dto.TodoDto;

@Controller
public class TodoController {
	
	@Autowired
	private TodoDao dao;
	
	
	@PostMapping("/todo/insert")
	public String insert(TodoDto dto) {//요청 파라미터가 추출되어서 MemberDto 객체에 담겨서 전달된다.
		//MemberDao 객체를 이용해서 DB에 저장하고
		dao.insert(dto);
		//응답하기
		return "todo/insert";
		
	}	
	@GetMapping("/todo/insertform")
	public String insertForm() {
		
		return "todo/insertform";
	}
	
	@GetMapping("/todo/list")
	public String list(Model model) {
		List<TodoDto> list=dao.getList();
		model.addAttribute("list", list);
		
		return "todo/list";
	}
}
