package com.webmark.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webmark.dao.MainDAO;
import com.webmark.dto.NoticeVO;

public class NoticeEditReady implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		long notice_num = Long.parseLong(request.getParameter("notice_num"));

		MainDAO dao = MainDAO.getInstance();
		NoticeVO vo = dao.getNoticeContents(notice_num);

		request.setAttribute("noticeCon", vo);
		String url = "/main/noticeEdit.jsp";

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}
}
