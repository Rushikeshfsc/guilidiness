package com.guielidnes.fluidscapes.service;

import java.net.InetAddress;
import java.util.List;

import com.guielidnes.fluidscapes.entity.LoginHistory;
import com.guielidnes.fluidscapes.repository.LoginDetailRepository;
import com.guielidnes.fluidscapes.repository.UserRepository;

public interface Loginservice {

	 
	//public List<Loginhistory> getall(String date, String ipaddress);
	
	//This is not in use know
	//void create(LoginHistory loginhistory);
	
	
	public  void Loginservice(UserService userService, LoginDetailRepository loginDetailRepository ,UserRepository userRepository);
	
	public boolean login(String username,String password,InetAddress ipaddress);

	
}
	
