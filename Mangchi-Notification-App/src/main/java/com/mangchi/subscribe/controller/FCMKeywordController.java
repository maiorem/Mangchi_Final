package com.mangchi.subscribe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mangchi.subscribe.model.NotificKeyRequest;
import com.mangchi.subscribe.model.Notification;
import com.mangchi.subscribe.service.NotificationDeleteService;
import com.mangchi.subscribe.service.NotificationListService;
import com.mangchi.subscribe.service.NotificationService;

@RestController
@RequestMapping("/fcmKey")
public class FCMKeywordController {
	
	@Autowired
	NotificationService noticeService;
	
	@Autowired
	NotificationListService noticeListService;
	
	@Autowired
	NotificationDeleteService noticeDeleteService;
	
	@PostMapping("/{noticeToken}")
	@CrossOrigin
	public int keywordConfig(NotificKeyRequest notReqesut) {
		return noticeService.insertKeyword(notReqesut);
	}
	
	@GetMapping("/{memberNick}")
	@CrossOrigin
	public List<Notification> selectKeyByNick(@PathVariable String memberNick) {
		return noticeListService.keywordByNick(memberNick);
	}
	
	@DeleteMapping("/{noticeIdx}")
	@CrossOrigin
	public int deleteKeyword(@PathVariable int noticeIdx) {
		return noticeDeleteService.deleteKey(noticeIdx);
	}

}
