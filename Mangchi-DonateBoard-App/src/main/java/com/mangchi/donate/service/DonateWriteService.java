package com.mangchi.donate.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mangchi.donate.dao.BoardDao;
import com.mangchi.donate.model.Board;
import com.mangchi.donate.model.BoardWriteRequest;

@Service
public class DonateWriteService {

	private BoardDao dao;

	@Autowired
	private SqlSessionTemplate template;


	public int writeDonate(BoardWriteRequest writeRequest, HttpServletRequest request) {
		dao=template.getMapper(BoardDao.class);
		Board donate=new Board(writeRequest.getWriter(), writeRequest.getTitle(), writeRequest.getContent(), writeRequest.getDoLoc());	
		
		int result=0;

		
		try {
			MultipartFile doImg=writeRequest.getDoImg();

			if(doImg!=null) {
				String uri="/upload";
				String realPath=request.getSession().getServletContext().getRealPath(uri);

				String fileName=System.nanoTime()+"_"+doImg.getOriginalFilename();

				File saveFile=new File(realPath, fileName);

				doImg.transferTo(saveFile);
				
				System.out.println("이미지 절대경로 : "+realPath);

			
				donate.setDoImg(fileName);
				
				
				System.out.println("저장 완료 : "+fileName);

			} else {
				donate.setDoImg("default.png");
			}
			
			System.out.println("게시글 생성 ==========> "+donate);
			result=dao.insertDonate(donate);

		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

}
