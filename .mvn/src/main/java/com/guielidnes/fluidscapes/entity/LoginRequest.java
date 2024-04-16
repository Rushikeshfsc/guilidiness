package com.guielidnes.fluidscapes.entity;

import java.io.Serializable;
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisHash;

import com.guielidnes.fluidscapes.controller.UserController;

@Entity
//@RedisHash("LoginRequest")
public class LoginRequest implements Serializable{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = -5969560498025969007L;

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="username should be null")
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

	@Override
	public int hashCode() {
		return Objects.hash(id, ipaddress, logintime, password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginRequest other = (LoginRequest) obj;
		return Objects.equals(id, other.id) && Objects.equals(ipaddress, other.ipaddress)
				&& Objects.equals(logintime, other.logintime) && Objects.equals(password, other.password)
				&& Objects.equals(username, other.username);
	}
	
	
	
	

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
}