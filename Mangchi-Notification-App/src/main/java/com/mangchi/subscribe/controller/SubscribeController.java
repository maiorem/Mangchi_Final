package com.mangchi.subscribe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mangchi.subscribe.model.SubscribeRequest;
import com.mangchi.subscribe.service.CheckSubsribeService;
import com.mangchi.subscribe.service.SubscribeDeleteService;
import com.mangchi.subscribe.service.SubsribeRegService;

@RestController
@RequestMapping("/sub")
public class SubscribeController {
	
	@Autowired
	SubsribeRegService regService;
	
	@Autowired
	SubscribeDeleteService deleteService;
	
	@Autowired
	CheckSubsribeService checkService;
	
	@PostMapping("/{token}")
	public int subscribeReg(SubscribeRequest subRequest) {
		return regService.subscriberReg(subRequest);
	}

	@DeleteMapping("/{memberNick}")
	public int deleteSub(@PathVariable String memberNick) {
		return deleteService.delete(memberNick);
	}
	
	@GetMapping("/{memberNick}")
	public int checkSubsribe(@PathVariable String memberNick) {
		return checkService.subsribeCheck(memberNick);
	}

}
