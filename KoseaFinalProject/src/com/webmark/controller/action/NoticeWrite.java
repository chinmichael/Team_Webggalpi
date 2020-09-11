package com.webmark.controller.action;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.webmark.dto.NoticeVO;

public class NoticeWrite implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());
		
		
		NoticeVO vo = new NoticeVO();
		vo.setUserid(request.getParameter("noticeWriter"));
		vo.setNotice_title(request.getParameter("noticeTitle"));
		vo.setNotice_contents(request.getParameter("noticeContents"));
		
		
		
	}

}
