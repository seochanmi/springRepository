package com.example.boot05.dao;

import java.util.List;

import com.example.boot05.dto.MemberDto;
import com.example.boot05.dto.TodoDto;


public interface TodoDao {
	public List<TodoDto> getList();
	public void insert(TodoDto dto);
	
}
