package com.webmark.dto;

public class UrlVO {
	
	private long url_num;
	private String url_address;
	private String url_name;
	private char url_access;
	private String tag;
	
	
	public long getUrl_num() {
		return url_num;
	}
	public void setUrl_num(long url_num) {
		this.url_num = url_num;
	}
	public String getUrl_address() {
		return url_address;
	}
	public void setUrl_address(String url_address) {
		this.url_address = url_address;
	}
	public String getUrl_name() {
		return url_name;
	}
	public void setUrl_name(String url_name) {
		this.url_name = url_name;
	}
	public char getUrl_access() {
		return url_access;
	}
	public void setUrl_access(char url_access) {
		this.url_access = url_access;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	

}
