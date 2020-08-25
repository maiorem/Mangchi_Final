package com.mangchi.subscribe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mangchi.subscribe.model.NotificationCheckRequest;
import com.mangchi.subscribe.model.SubscribeCheckRequest;
import com.mangchi.subscribe.util.FcmKeyNotificationUtil;
import com.mangchi.subscribe.util.FcmSubscribeUtil;

@RestController
@RequestMapping("/register")
public class NotificationApiController {
	
	@Autowired
	FcmSubscribeUtil subscribeUtil;
	
	@Autowired
	FcmKeyNotificationUtil keyUtil;
	
	@GetMapping
	public void subscribeNotification(SubscribeCheckRequest subRequest) {
		System.out.println("구독 체크 요청 : "+subRequest);
		subscribeUtil.sendFcm(subRequest);
		
	} 
	
	
	@GetMapping("/{token}")
	public void keyNotification(NotificationCheckRequest noticRequest) {

		keyUtil.sendFcm(noticRequest);
	}
	
	@PostMapping
	public ResponseEntity register(@RequestBody String token, SubscribeCheckRequest subRequest, NotificationCheckRequest noticRequest) {
		subscribeUtil.sendFcm(subRequest);
		keyUtil.sendFcm(noticRequest);
		return ResponseEntity.ok().build();
	}


}
