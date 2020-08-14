package com.mangchi.donate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mangchi.donate.model.CommWriteRequest;
import com.mangchi.donate.model.Comments;
import com.mangchi.donate.service.CommWriteService;
import com.mangchi.donate.service.DonateCommentListService;

@RestController
@RequestMapping("/comments")
public class DonateCommentsRestController {
	
	@Autowired
	DonateCommentListService listService;
	
	@Autowired
	CommWriteService writeService;
	
	
	@GetMapping("/{donateIdx}")
	public List<Comments> getCommentList(@PathVariable("donateIdx") int donateIdx){
		return listService.getCommList(donateIdx);
		
	}
	
	@PostMapping
	public int writeComm(CommWriteRequest writeRequest) {
		return writeService.writeComments(writeRequest);
	}
	
	

}
