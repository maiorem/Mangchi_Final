package com.mangchi.donate.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.JsonObject;
import com.mangchi.donate.model.Board;
import com.mangchi.donate.model.BoardWriteRequest;
import com.mangchi.donate.service.DonateListService;
import com.mangchi.donate.service.DonateViewService;
import com.mangchi.donate.service.DonateWriteService;

@RestController
@RequestMapping("/donateBoard")
public class BoardRestController {
	
	@Autowired
	DonateListService listService;
	
	@Autowired
	DonateViewService viewService;
	
	@Autowired
	DonateWriteService writerService;
	
	// 리스트 출력
	@GetMapping
	public List<Board> getBoardList(){
		return listService.getBoardList();
	}
	
	//idx로 개별 뷰 출력
	@GetMapping("/{idx}")
	public Board getBoardView(@PathVariable int idx) {
		return viewService.getViewByidx(idx);
	}
	
	//글쓰기
	@PostMapping
	public int write(BoardWriteRequest writeRequest, HttpServletRequest request) {
		System.out.println("글쓰기 요청 받기 =====> "+writeRequest);
		return writerService.writeDonate(writeRequest, request);
	}

	
	//글수정
	
	//글삭제

}
