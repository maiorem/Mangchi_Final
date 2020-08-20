package com.mangchi.donate.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mangchi.donate.model.CommReplyRequest;
import com.mangchi.donate.model.CommWriteRequest;
import com.mangchi.donate.model.CommentListView;
import com.mangchi.donate.service.CommDeleteService;
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
	
	@Autowired
	CommDeleteService deleteService;
	
	
	@GetMapping("/{donateIdx}")
	@CrossOrigin
	public CommentListView getCommentList(@PathVariable("donateIdx") int donateIdx, HttpServletRequest request){
		return listService.getCommList(donateIdx, request);
		
	}
	
	//댓글 쓰기
	@PostMapping
	@CrossOrigin
	public int writeComm(CommWriteRequest writeRequest) {
		return writeService.writeComments(writeRequest);
	}
	
	//대댓글 쓰기
	@PostMapping("/reply")
	@CrossOrigin
	public int writereplyComm(CommReplyRequest replyRequest) {
		return replySerivce.reply(replyRequest);
	}
	
	@DeleteMapping("/{commIdx}")
	@CrossOrigin
	public int deleteComm(@PathVariable int commIdx) {
		return deleteService.deleteMessage(commIdx);		
	}
	
	
	

}
