package com.example.boot10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.boot10.dao.PostDao;
import com.example.boot10.dto.PostDto;
import com.example.boot10.service.PostService;

@RestController // @ResponseBody 의 기능이 모든 메소드에 포함된다.
@RequestMapping("/v2")
public class PostController2 {
	//dao 대신에 필요한 서비스객체를 interface type 으로 주입받는다
	@Autowired private PostService service;
	
	@GetMapping("/posts")
	public List<PostDto> getList(){
		//글 전체 목록을 service 객체를 이용해서 읽어온 다음
		List<PostDto> list=service.getAll();
		//리턴해준다
		return list;
	}
	
	/*
	@PostMapping("/posts")
	public PostDto insert(String title, String author) {
		// @Builder 의 기능을 이용해서 PostDto 객체에 데이터를 담으면서 객체의 참조값 얻어내기
		PostDto dto=PostDto.builder().title(title).author(author).build();
		//dao 를 이용해서 dto에 저장된 정보를 DB에 저장하기
		dao.insert(dto);
		//현재 추가된 정보를 리턴하기
		return dto;
	}
	*/
	
	/*
	 * 요청의 body 에 json 문자열이 전송되면 요청 파라미터를 추출하는 방법이 다르다.
	 * 
	 *  spring 프레임워크에서는 @RequestBody 라는 어노테이션을 붙여주면 된다.
	 *  
	 *  그러면 json 문자열의 key 와 dto 의 필드명이 일치하면 데이터가 추출되어서 필드에 저장된다.
 	 * {"title" : ""}   String title: 
	 */
	
	//요청 파라미터 추출을 좀더 편한 방법으로 하면 아래와 같다     id 의 경우 sequence 라서 0으로 되어있는데 이것을 바꿔주려면!
	@PostMapping("/posts")
	public PostDto insert(@RequestBody PostDto dto) {// title 과 author 가 추출되어서 PostDto 객체에 담긴채로 전달된다. 따로 추출해서 담을필요없음
		//서비스를 이용해서 글을 저장하고 리턴해주는 PostDto 를 컨트롤러에서 리턴해준다.
		return service.addContent(dto);
	}
	
	@GetMapping("/posts/{id}")
	public PostDto getData(@PathVariable("id") int id) {
		//서비스를 이용해서 글하나의 정보를 얻어와서 리턴해준다.
		return service.getContent(id);
	}
	
	@DeleteMapping("/posts/{id}")
	public PostDto delete(@PathVariable("id") int id) {
		//서비스를 이용해서 글을 삭제하고 리턴되는 글정보를 리턴한다. 
		return service.removeContent(id);
	}
	
	@PutMapping("/posts/{id}")
	public PostDto update(@PathVariable("id") int id,@RequestBody PostDto dto) {
		//PostDto 에 경로 변수로 넘어오는 수정할 글번호도 담아서
		dto.setId(id);
		
		//서비스를 이용해서 수정한다
		service.updateContent(dto);
		//수정된 데이터를 리턴해준다
		return dto;
	}
}
