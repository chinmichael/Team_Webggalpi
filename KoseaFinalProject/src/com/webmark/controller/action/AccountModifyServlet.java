package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saeyan.dto.AccountVO;
import com.saeyan.dto.MemberDAO;
/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/Account.do")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	RequestDispatcher dispatcher = request
			.getRequestDispatcher("join.jsp");
	dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		String user_pw = request.getParameter("user_pw");
		String user_name = request.getParameter("user_name");
		String user_nick = request.getParameter("user_nick");
		String e_mail = request.getParameter("e_mail");
		
		AccountVO mVo =new AccountVO();
		mVo.setUserpw(user_pw);
		mVo.setUsername(user_name);
		mVo.setUsernick(user_nick);
		mVo.setEmail(e_mail);
		
		MemberDAO mDao = MemberDAO.getInstance();
		int result=mDao.modifyAccount(mVo);
		
		HttpSession session =request.getSession();
		
		if(result==1) {
			session.setAttribute("user_id",mVo.getUserid());
			request.setAttribute("message", "정보변경 성공.");
		}else {
			request.setAttribute("message", "정보변경 실패.");
			
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
		
//		doGet(request, response);
	}

}
