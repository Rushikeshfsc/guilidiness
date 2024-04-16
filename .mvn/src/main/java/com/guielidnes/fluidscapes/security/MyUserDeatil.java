package com.guielidnes.fluidscapes.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.guielidnes.fluidscapes.entity.Users;
import com.guielidnes.fluidscapes.repository.UserRepository;
import com.guielidnes.fluidscapes.service.UserService;

import javassist.NotFoundException;

@Service
@Primary
public class MyUserDeatil  implements UserService{

	@Autowired
	private UserRepository userrepo;
	
//	public UserDetails loadusername(String name) throws NotFoundException{
//		
//	final Users appuser = userrepo.findByUsername(name);
//		
//	
//	if(appuser==null) {
//		throw new UsernameNotFoundException("name"+name+"notfound");
//	}
//	return org.springframework.security.core.userdetails.User.withUsername(name).password(appuser.getPassword())
//			.authorities(appuser.getUsername().toString()).accountExpired(false).accountLocked(false)
//			.credentialsExpired(false).disabled(false).build();
//	
//	
//	
//	}

	@Override
	public void Userservice(UserRepository userRepository) {
		
		
	}

	@Override
	public Users findByUsername(String username) throws UsernameNotFoundException {
		
		final Users appuser = userrepo.findByUsername(username);
		
		if(appuser==null) {
			throw new UsernameNotFoundException("name"+username+"notfound");
		}
		
	return (Users) org.springframework.security.core.userdetails.User.withUsername(username).password(appuser.getPassword())
	.authorities(appuser.getUsername().toString()).accountExpired(false).accountLocked(false)
	.credentialsExpired(false).disabled(false).build();
	
	}

	@Override
	public Users create(Users user) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
