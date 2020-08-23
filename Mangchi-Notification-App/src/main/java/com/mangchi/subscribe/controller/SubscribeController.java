package com.mangchi.subscribe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mangchi.subscribe.model.SubscribeRequest;
import com.mangchi.subscribe.service.SubscribeDeleteService;
import com.mangchi.subscribe.service.SubsribeRegService;

@RestController
@RequestMapping("/sub")
public class SubscribeController {
	
	@Autowired
	SubsribeRegService regService;
	
	@Autowired
	SubscribeDeleteService deleteService;
	
	@PostMapping("/{token}")
	public int subscribeReg(SubscribeRequest subRequest, Model model) {
		model.addAttribute("subsribe", regService.subscriberReg(subRequest));
		return regService.subscriberReg(subRequest);
	}

	@DeleteMapping("/{memberNick}")
	public int deleteSub(@PathVariable String memberNick) {
		return deleteService.delete(memberNick);
	}

}
