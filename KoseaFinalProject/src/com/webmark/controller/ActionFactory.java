package com.webmark.controller;

import com.webmark.controller.action.Action;
import com.webmark.controller.action.AddCategory;
import com.webmark.controller.action.AddUrl;
import com.webmark.controller.action.DeleteCategory;
import com.webmark.controller.action.DeleteUrl;
import com.webmark.controller.action.EditUrl;
import com.webmark.controller.action.Logout;
import com.webmark.controller.action.NoticeBoard;
import com.webmark.controller.action.NoticeList;
import com.webmark.controller.action.SampleLogin;
import com.webmark.controller.action.SearchUrl;
import com.webmark.controller.action.UrlList;

public class ActionFactory {
	
	private static ActionFactory instance = new ActionFactory();
	
	private ActionFactory() {
		super();
	}
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		
		Action action = null;
		
		switch(command) {
		
		case "sample_account":
			action = new SampleLogin();
			break;
			
		case "logout":
			action = new Logout();
			break;
		
		case "url_list":
			action = new UrlList();
			break;
			
		case "add_url":
			action = new AddUrl();
			break;
			
		case "delete_url":
			action = new DeleteUrl();
			break;
			
		case "edit_url":
			action = new EditUrl();
			break;
			
		case "search_url":
			action = new SearchUrl();
			break;
			
		case "add_category":
			action = new AddCategory();
			break;
		
		case "delete_category":
			action = new DeleteCategory();
			break;
		
		case "notice_list":
			action = new NoticeList();
			break;
			
		case "notice_board":
			action = new NoticeBoard();
			break;
			
		}

		return action;
	}
	
}
