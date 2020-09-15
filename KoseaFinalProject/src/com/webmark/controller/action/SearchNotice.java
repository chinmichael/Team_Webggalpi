package com.webmark.controller.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webmark.dao.MainDAO;
import com.webmark.dto.NoticePagingVO;
import com.webmark.dto.NoticeVO;

public class SearchNotice implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String parsePage = request.getParameter("page");
		
		if(parsePage == null) {
			parsePage = "1";
		}
		
		long initPage = Long.parseLong(parsePage);
		
		NoticePagingVO vo = new NoticePagingVO();
		vo.setPage(initPage);
		
		String searchName = request.getParameter("noticeSearch");
		boolean searchType;
		String searchTypeParameter = request.getParameter("noticeSearchType");
		if(searchTypeParameter.equals("1")) {
			searchType = true;
		} else {
			searchType = false;
		}
		
		List<NoticeVO> pagingList = new Vector<>();
		MainDAO dao = MainDAO.getInstance();
		
		pagingList = dao.getSearchNoticePagingList(vo, searchName, searchType);
		
		HashMap<String, Object> searchNoticePagingCnt = dao.getSearchNoticePagingCnt(vo, searchName, searchType);
		HashMap<String, Object> resMap = new HashMap<String, Object>();
		
		resMap.put("total", searchNoticePagingCnt.get("totalPage"));
		resMap.put("page", vo.getPage());
		resMap.put("pageScale", vo.getPageScale());
		
		int pageGroup = (int)Math.ceil((double)vo.getPage() / vo.getPageScale());
		
		long startPage = (pageGroup - 1) * vo.getPageScale() + 1;
		vo.setStartPage(startPage);
		resMap.put("startPage", vo.getStartPage());
		
		long endPage = startPage + vo.getPageScale() - 1;
		vo.setEndPage(endPage);
		resMap.put("endPage", vo.getEndPage());
		
		long prePage = (pageGroup - 2) * vo.getPageScale() + 1;
		long nextPage = (pageGroup) * vo.getPageScale() + 1;
		
		resMap.put("nextPage", nextPage);
		resMap.put("prePage", prePage);
		resMap.put("pageGroup", pageGroup);
		
		request.setAttribute("pagingList", pagingList);
		request.setAttribute("resMap", resMap);
		request.setAttribute("searchName", searchName);
		request.setAttribute("searchTypeParameter", searchTypeParameter);
		
		String url = "/main/searchNotice.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
