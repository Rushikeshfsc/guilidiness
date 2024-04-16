package com.guielidnes.fluidscapes.controller;

import java.net.InetAddress;
import java.time.Duration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.net.UnknownHostException;

import org.hibernate.internal.SessionFactoryRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guielidnes.fluidscapes.entity.Users;

import com.guielidnes.fluidscapes.entity.LoginRequest;

import com.guielidnes.fluidscapes.service.Loginservice;
import com.guielidnes.fluidscapes.service.UserService;

import springfox.documentation.schema.Model;



@CrossOrigin
@RestController
@RequestMapping("/admin")
public class UserController {
	//Logger setup
   private static final Logger logger=LoggerFactory.getLogger(UserController.class)	;
    ///
     @Autowired
	private UserService userService;
	@Autowired
	private Loginservice loginservice;
	
	//@Autowired
	//private Sessionsecurity session;

	//@Autowired
	//private SessionRepository<Session>sessionRepository;
	
	public UserController(UserService userservice,Loginservice loginservice) {
		this.userService=userservice;
		this.loginservice=loginservice;
		
	}
	@PostMapping("/login")
	public ResponseEntity<String >login(@RequestBody @Valid LoginRequest loginRequest,HttpServletResponse httpServletResponse) throws UnknownHostException{
		//List<String> message=(List<String>) httpSession.getSession().getAttribute("My_Session");
		
		
		if(loginservice.login(loginRequest.getUsername(), loginRequest.getPassword(),InetAddress.getLocalHost() )) {
			
		//	httpSession.setAttribute("My_Session", loginRequest);
			
		
	
			
			return ResponseEntity.ok("Login Successfull"+loginRequest.toString());
			
		}
		
		else {
		logger.info("Login of user controller:login() method");
		
		
		return ResponseEntity.badRequest().body("Invalide username or Password");
		}
		
		
	}
	
	@PostMapping("/register")
	public String register(@RequestBody  @Valid Users user) {
		
		Users existinguser = userService.findByUsername(user.getUsername());
		if(existinguser==null) {
			userService.create(user);
			
			logger.info("Register User Controller:register() method");
			return "Registration succcessfully"+user.toString();
		}else {
		return "username already exit";
		
		}
		
	}
	
	
//     @GetMapping("/getip/{id}")
//		public ResponseEntity<String>loginss(@PathVariable String id) throws UnknownHostException{
//			InetAddress IP=InetAddress.getLocalHost();
//			
//		System.out.println("ip of my System is:-"+IP.getHostAddress());
//			return ResponseEntity.badRequest().body("Invalid User or Paswword");
//			
	
	
//	//@Bean
//   private void setSessionTimeout(HttpServletResponse response,HttpSession httpSession) {
//	
//        Session session = sessionRepository.findById("set_currentsessionId");
//		if(session!=null) {
//			
//			session.setMaxInactiveInterval(Duration.ofMinutes(2));
//			sessionRepository.save(session);
//			
//			
//		}
//		
	}
	


	


	/////...............................................................................................................

	
	
	

		
	





	
	
	
	
	
	
	

