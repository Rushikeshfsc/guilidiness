package com.guielidnes.fluidscapes.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Password {
 
	static BCryptPasswordEncoder encode=new BCryptPasswordEncoder();
	
	public static String getPasswordHash(String password) {
		return encode.encode(password);
	}
	
	
	public static boolean matchPassword(String oldpassword,String encodePassword) {
		return encode.matches(oldpassword, encodePassword);
	}
	
}
