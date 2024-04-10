package com.guielidnes.fluidscapes.entity;

import java.net.InetAddress;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

import com.guielidnes.fluidscapes.controller.UserController;

@Entity
public class LoginRequest {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	
	private String password;
	 
	private LocalDateTime logintime;
	
	private  InetAddress ipaddress;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getLogintime() {
		return logintime;
	}

	public void setLogintime(LocalDateTime logintime) {
		this.logintime = logintime;
}

	public InetAddress getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(InetAddress ipaddress) {
		this.ipaddress = ipaddress;
	}

	@Override
	public String toString() {
		return "LoginRequest [id=" + id + ", username=" + username + ", password=" + password + ", logintime="
				+ logintime + ", ipaddress=" + ipaddress + "]";
	}
	
	
	
	

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
}