package com.webmark.controller.action;

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
@WebServlet({ "/LoginServlet", "/login.do" })
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	  
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("member/login.jsp");
	    dispatcher.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	  String url="member/login.jsp";
	  
      String user_id = request.getParameter("user_id");
      String user_pw = request.getParameter("user_pw");
	 
      LoginDAO mDao = LoginDAO.getInstance();
      int result =mDao.userCheck(user_id, user_pw);
      
      if(result==1) {
    	  AccountVO mVo = mDao.getMember(user_id);
    	  MainDAO dao = MainDAO.getInstance();
    	  List<CategoryVO> list = dao.getCategoryList(user_id);
    	  
    	  HttpSession session = request.getSession();
    	  session.setAttribute("Account", mVo);
    	  session.setAttribute("categoryList", list);
    	  session.setMaxInactiveInterval(24*60*60);
    	  url="/main/markList.jsp";
    	  
      }else if(result==0) {
    	  request.setAttribute("message", "비밀번호가 맞지 않습니다.");
    	  
      }else if(result== -1) {
    	  request.setAttribute("message", "존재하지 않는 회원입니다");
      }
      
      RequestDispatcher dispatcher = request
    		  .getRequestDispatcher(url);
      dispatcher.forward(request, response);
	}

}