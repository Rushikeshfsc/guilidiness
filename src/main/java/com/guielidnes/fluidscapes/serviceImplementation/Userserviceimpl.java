package com.guielidnes.fluidscapes.serviceImplementation;

import javax.security.auth.login.AccountNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.guielidnes.fluidscapes.entity.Users;
import com.guielidnes.fluidscapes.repository.UserRepository;
import com.guielidnes.fluidscapes.service.UserService;

@Service
public class Userserviceimpl implements UserService{
	
	
	private static final Logger logger=LoggerFactory.getLogger(Userserviceimpl.class);

    @Autowired
	private UserRepository userRepository;

	@Override
	public void Userservice(UserRepository userRepository) {
		this.userRepository=userRepository;
		
		
	}

	@Override
	public Users findByUsername(String username) {
		logger.info("user service find user method:findByUsername() method");
		return userRepository.findByUsername(username);
	
	}
	

	@Override
	public Users create(Users user) {
		
		BCryptPasswordEncoder bcrypt=new BCryptPasswordEncoder();
		
		String encrypt = bcrypt.encode(user.getPassword());
		user.setPassword(encrypt);
		
		logger.info("user service implementation:create() method");
		return userRepository.save(user);
	}
	
	/*
	 * @Override public Adminlogin loginuser(String username, String password)
	 * throws Exception {
	 * 
	 * Adminlogin admin=repo.finbyUsername(username, password);
	 * 
	 * 
	 * if(admin==null) { //throw new com.guielidnes.fluidscapes.exception.
	 * Exception("You Entered incorrect username"); } else {
	 * if(admin.getUsername().equals(username)&&
	 * admin.getPassword().equals(password)) { return repo.save(admin); } }
	 * 
	 * //throw new com.guielidnes.fluidscapes.exception.
	 * Exception("You entered Incorrect Password"); }
	 */

//	@Override
//	public void saveadmin(Users adminlogin) {
//	
//		repo.save(adminlogin);
//	}
	
	
    
    
    
	

}
