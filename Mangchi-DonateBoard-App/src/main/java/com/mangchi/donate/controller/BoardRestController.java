package com.mangchi.donate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mangchi.donate.model.Board;
import com.mangchi.donate.service.DonateListService;

@RestController
@RequestMapping("/donateBoard")
public class BoardRestController {
	
	@Autowired
	DonateListService listService;
	
	@GetMapping
	public List<Board> getBoardList(){
		return listService.getBoardList();
	}

}
