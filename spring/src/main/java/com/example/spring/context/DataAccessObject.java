package com.example.spring.context;

public class DataAccessObject {
	String url;
	String driver;
	String username;
	String password;
	
	public void init(){
		System.out.println("DAO object instantiated....");
		
	}

	public void destroy() {
		System.out.println("DAO object destroyed.... ");
	}
}
