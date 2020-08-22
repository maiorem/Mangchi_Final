package com.mangchi.subscribe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mangchi.subscribe.model.SubscribeRequest;
import com.mangchi.subscribe.service.SubsribeRegService;

@RestController
@RequestMapping("/sub")
public class SubscribeController {
	
	@Autowired
	SubsribeRegService regService;
	
	@PostMapping("/{token}")
	public int subscribeReg(SubscribeRequest subRequest) {
		return regService.subscriberReg(subRequest);
	}


}
