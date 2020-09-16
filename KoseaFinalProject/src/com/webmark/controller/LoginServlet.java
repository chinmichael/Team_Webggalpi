package com.webmark.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webmark.dao.LoginDAO;
import com.webmark.dao.MainDAO;
import com.webmark.dto.AccountVO;
import com.webmark.dto.CategoryVO;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		
		String user_id = request.getParameter("userid");
		String user_pw = request.getParameter("userpw");

		LoginDAO mDao = LoginDAO.getInstance();
		int result = mDao.userCheck(user_id, user_pw);

		String url = "";

		if (result == 1) {
			AccountVO mVo = mDao.getMember(user_id);
			MainDAO dao = MainDAO.getInstance();
			List<CategoryVO> list = dao.getCategoryList(user_id);

			HttpSession session = request.getSession();
			session.setAttribute("account", mVo);
			session.setAttribute("categoryList", list);
			session.setMaxInactiveInterval(24 * 60 * 60);

			url = "/main/markList.jsp";

		} else if (result == 0) {
			request.setAttribute("message", "Please check your password.");
			url = "/login/Login.jsp";

		} else if (result == -1) {
			request.setAttribute("message", "Please check your ID.");
			url = "/login/Login.jsp";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
