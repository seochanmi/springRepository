package com.example.boot11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriUtils;

import com.example.boot11.dto.FileDto;
import com.example.boot11.service.FileService;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
public class FileController {
	
	
	
    @Autowired
    private FileService service;
    
    @GetMapping("/file/delete")
    public String delete(int num) { //삭제할 파일번호가 전달된다.
        service.deleteFile(num);
        return "redirect:/file/list";
    }

    @GetMapping("/file/download")
    public ResponseEntity<InputStreamResource> download(int num){ //다운로드할 파일번호가 전달된다.
    	return service.getFileData(num);
    }
    
    @PostMapping("/file/upload")
    public String upload(FileDto dto) {
    	
    	service.saveFile(dto);
    	
    	return "file/upload";
    }

    @GetMapping("/file/upload_form")
    public String uploadForm() {
    	
        return "file/upload_form";
    }
    /*
     *	FileDto 에는 pageNum, condition, keyword 값이 담길수도 있다.
     *  (GET 방식 파라미터값이 넘어오면 담긴다) 
     * 
     */
    @GetMapping("/file/list")
    public String list(Model model, FileDto dto) {
    	//서비스 객체에 Model 의 참조값을 전달해서 파일목록이 Model 객체에 담기도록 한다.
    	service.getList(model, dto);
    	//template 페이지에서 파일 목록 응답하기
        return "file/list";
    }

    
   
}
