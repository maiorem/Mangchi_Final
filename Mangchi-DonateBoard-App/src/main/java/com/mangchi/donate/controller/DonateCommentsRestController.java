package com.mangchi.donate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mangchi.donate.model.CommReplyRequest;
import com.mangchi.donate.model.CommWriteRequest;
import com.mangchi.donate.model.Comments;
import com.mangchi.donate.service.CommReplyService;
import com.mangchi.donate.service.CommWriteService;
import com.mangchi.donate.service.DonateCommentListService;

@RestController
@RequestMapping("/comments")
public class DonateCommentsRestController {
	
	@Autowired
	DonateCommentListService listService;
	
	@Autowired
	CommWriteService writeService;
	
	@Autowired
	CommReplyService replySerivce;
	
	
	@GetMapping("/{donateIdx}")
	public List<Comments> getCommentList(@PathVariable("donateIdx") int donateIdx){
		return listService.getCommList(donateIdx);
		
	}
	
	//댓글 쓰기
	@PostMapping
	public int writeComm(CommWriteRequest writeRequest) {
		return writeService.writeComments(writeRequest);
	}
	
	//대댓글 쓰기
	@PostMapping("/reply")
	public int writereplyComm(CommReplyRequest replyRequest) {
		return replySerivce.reply(replyRequest);
	}
	
	
	
	

}
