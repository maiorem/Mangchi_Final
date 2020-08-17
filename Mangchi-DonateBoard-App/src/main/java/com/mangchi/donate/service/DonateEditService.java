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
import com.mangchi.donate.model.BoardEditRequest;

@Service
public class DonateEditService {
	
	private BoardDao dao;
	
	@Autowired
	private SqlSessionTemplate template;

	public int editBoard(BoardEditRequest editRequest, HttpServletRequest request) {
		dao=template.getMapper(BoardDao.class);
		
		int result=0;
		
		Board board=new Board(editRequest.getDonateIdx(), editRequest.getWriter(), editRequest.getTitle(), editRequest.getContent(), editRequest.getOldImg(), editRequest.getDoLoc(), editRequest.getDoStatus());
		
		try {
			
			MultipartFile doImg=editRequest.getDoImg();
			
			if(doImg!=null) {
				String uri="/upload";
				String realPath=request.getSession().getServletContext().getRealPath(uri);

				String fileName=System.nanoTime()+"_"+doImg.getOriginalFilename();

				File saveFile=new File(realPath, fileName);

				doImg.transferTo(saveFile);
				board.setDoImg(fileName);
				
				File oldFile = new File(realPath, editRequest.getOldImg());
		
				if (oldFile.exists()) {
					oldFile.delete();
				}

				System.out.println("저장 완료 : "+fileName);
			}
			
			result=dao.editDonateBoard(board);
		
		}catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		return result;
	}

}
