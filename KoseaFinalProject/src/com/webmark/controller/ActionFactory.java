package com.webmark.controller;

import com.webmark.controller.action.Action;
import com.webmark.controller.action.SampleLogin;
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
		
		case "url_list":
			action = new UrlList();
			break;	
			
			
		}
		
		return action;
		
	}
	
}
