package com.webmark.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webmark.dao.MainDAO;
import com.webmark.dto.AccountVO;
import com.webmark.dto.UrlVO;

public class UrlList implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		long cat_no = Long.parseLong(request.getParameter("cat_no"));
		
		HttpSession session = request.getSession();
		AccountVO vo = (AccountVO) session.getAttribute("account");
		String userid = vo.getUserid();
		
		MainDAO dao = MainDAO.getInstance();
		
		String check_id = dao.checkID(cat_no);
		
		String url = "/main/markList.jsp";
		
		if(check_id.equals(userid)) {
			List<UrlVO> list = dao.getUrlList(cat_no);
			
			request.setAttribute("urlList", list);
			request.setAttribute("cat_no", request.getParameter("cat_no"));

		} 
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
