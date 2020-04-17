package com.gateway.message;

public class Message {

	public static String Unauthorize = "User Cannot Access the resource"; 
	
	public static String addToken ="You have to have a bearer token to get this services";
	
	public static String path(String path) {
		return "/"+path;
	}
	
}
