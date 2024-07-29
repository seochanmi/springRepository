package com.example.boot11.service;

import java.util.List;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.example.boot11.dto.FileDto;

import lombok.RequiredArgsConstructor;

public interface FileService {
	public void getList(Model model, FileDto dto); //파일 목록을 Model 객체에 담아주는 메소드
	public void saveFile(FileDto dto);//파일 정보를 저장하는 메소드

	public ResponseEntity<InputStreamResource> getFileData(int num); //다운로드 해줄 파일 하나의 정보 얻어오기
	void deleteFile(int num); //파일 삭제
	
}
