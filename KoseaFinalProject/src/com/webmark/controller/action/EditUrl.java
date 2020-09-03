package com.webmark.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webmark.dao.MainDAO;
import com.webmark.dto.UrlVO;

public class EditUrl implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String tag = request.getParameter("urlTagE") == null ? "none" : request.getParameter("urlTagE");
		
		long cat_no = Long.parseLong(request.getParameter("categorySelectE"));
		long cat_no_p = Long.parseLong(request.getParameter("cat_no"));
		
		UrlVO vo = new UrlVO();
		vo.setUrl_num(Long.parseLong(request.getParameter("url_num")));
		vo.setUrl_address(request.getParameter("urlLinkE"));
		vo.setUrl_name(request.getParameter("urlNameE"));
		vo.setUrl_access(request.getParameter("accessUrlE"));
		vo.setTag(tag);
		
		MainDAO dao = MainDAO.getInstance();
		int result = dao.editUrl(cat_no, vo);
			
		List<UrlVO> list = null;
		
		if (result == 1) {
			list = dao.getUrlList(cat_no);
			request.setAttribute("urlList", list);
			request.setAttribute("cat_no", Long.toString(cat_no));
		} else {
			list = dao.getUrlList(cat_no_p);
			request.setAttribute("urlList", list);
			request.setAttribute("cat_no", Long.toString(cat_no_p));
			request.setAttribute("message", "This url name is already in category.");
		}

		String url = "/main/markList.jsp";

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
