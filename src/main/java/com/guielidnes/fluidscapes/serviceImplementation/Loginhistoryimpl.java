package com.guielidnes.fluidscapes.serviceImplementation;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.guielidnes.fluidscapes.entity.LoginHistory;
import com.guielidnes.fluidscapes.entity.Users;
import com.guielidnes.fluidscapes.repository.LoginDetailRepository;
import com.guielidnes.fluidscapes.repository.UserRepository;
import com.guielidnes.fluidscapes.service.Loginservice;
import com.guielidnes.fluidscapes.service.UserService;


@Service
public class Loginhistoryimpl implements Loginservice {
	
	private static final Logger logger=LoggerFactory.getLogger(Loginhistoryimpl.class);
	
  @Autowired
	private UserService userService;
  @Autowired
	private LoginDetailRepository loginDetailRepository;
  @Autowired
  private UserRepository userrepository;

@Override
public void Loginservice(UserService userService, LoginDetailRepository loginDetailRepository,UserRepository userrepository) {
	this.userService=userService;
	this.loginDetailRepository=loginDetailRepository;
	this.userrepository=userrepository;
	
}

@Override
public boolean login(String username, String password, InetAddress ipaddress) {
	 
Users user = userService.findByUsername(username);	

BCryptPasswordEncoder brcypt= new BCryptPasswordEncoder();


	try {
		InetAddress localhost=(InetAddress) InetAddress.getLocalHost();
		
	} catch (UnknownHostException e) {
		
		e.printStackTrace();
	}
/////////////////////////////////////////////////////////////////////////////////	
	
	
	if(brcypt.matches(password, user.getPassword())) {
////////////////////////////////////////////////////////////////////////////////	
	 //if(user!=null && user.getPassword().equals(password)) {
	LoginHistory loginhistory=new LoginHistory();
	loginhistory.setUser(user);
	loginhistory.setLogintime(LocalDateTime.now());
   try {
	loginhistory.setIpaddress(InetAddress.getLocalHost());
} catch (UnknownHostException e) {
	
	e.printStackTrace();
}
   
	loginDetailRepository.save(loginhistory);
	
	logger.info("Login service implementation :login() method");
	
return true;
}
return false;

	
//return false;
}
}

	


