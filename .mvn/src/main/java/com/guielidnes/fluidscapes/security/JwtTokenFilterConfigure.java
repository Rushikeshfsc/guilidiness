package com.guielidnes.fluidscapes.security;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JwtTokenFilterConfigure extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>{

	@Autowired
	private JWTTokenProvider jwtTokenProvider;
	
	
	public JwtTokenFilterConfigure(JWTTokenProvider jwtTokenProvider) {
		this.jwtTokenProvider=jwtTokenProvider;
	}
	
	public void configure(HttpSecurity http) throws Exception {
		
		JwtTokenFilter customfilter=new JwtTokenFilter(jwtTokenProvider);
		http.addFilterBefore(customfilter, UsernamePasswordAuthenticationFilter.class);
		
		
	}
	
	
}

