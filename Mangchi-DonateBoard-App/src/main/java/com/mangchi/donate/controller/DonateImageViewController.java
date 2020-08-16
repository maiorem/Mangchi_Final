package com.mangchi.donate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mangchi.donate.service.ImageViewService;

@RestController
@RequestMapping("/donate/upload")
public class DonateImageViewController {
	
	@Autowired
	private ImageViewService imgService;
	
	 @GetMapping("/{doImg}")
	 public String getViewImg(@PathVariable String doImg) {
		 return imgService.viewImg(doImg);
	 }

}
