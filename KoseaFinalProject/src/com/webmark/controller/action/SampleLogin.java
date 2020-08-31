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
import com.webmark.dto.CategoryVO;

public class SampleLogin implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String userid = "chintemp";
		
		MainDAO dao = MainDAO.getInstance();
		AccountVO vo = dao.sampleAccount(userid);
		List<CategoryVO> list = dao.categoryList(userid);
		
		HttpSession session = request.getSession();
		session.setAttribute("account", vo);
		session.setAttribute("categoryList", list);
		
		String url = "/main/markList.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
