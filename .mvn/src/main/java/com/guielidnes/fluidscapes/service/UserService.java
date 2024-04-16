package com.guielidnes.fluidscapes.service;

import com.guielidnes.fluidscapes.entity.Users;
import com.guielidnes.fluidscapes.repository.UserRepository;

public interface UserService {
	
	//public Adminlogin loginuser(String username, String password ) throws Exception;
	//not know use this
	//void  saveadmin(Users adminlogin); 
	
	public void Userservice(UserRepository userRepository);
	    
     public Users findByUsername(String username);
     
     public Users create(Users user);
}
