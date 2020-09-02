package com.webmark.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webmark.dao.MainDAO;
import com.webmark.dto.UrlVO;

public class DeleteUrl implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		long url_num = Long.parseLong(request.getParameter("url_num"));
		MainDAO dao = MainDAO.getInstance();
		dao.deletUrl(url_num);
		
		long cat_no = Long.parseLong(request.getParameter("cat_no"));
		
		List<UrlVO> list = dao.getUrlList(cat_no);
		
		request.setAttribute("urlList", list);
		request.setAttribute("cat_no", Long.toString(cat_no));
		String url = "/main/markList.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
