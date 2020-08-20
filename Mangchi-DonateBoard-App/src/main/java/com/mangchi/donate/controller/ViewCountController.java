package com.mangchi.donate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mangchi.donate.service.ViewCountService;

@RestController
@RequestMapping("/viewCnt")
public class ViewCountController {
	
	@Autowired
	ViewCountService cntService;
	
	@GetMapping("/{donateIdx}")
	@CrossOrigin
	public int countView(@PathVariable int donateIdx) {
		return cntService.cntView(donateIdx);
	}

}
