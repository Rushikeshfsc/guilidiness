package com.guielidnes.fluidscapes.entity;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="login_history")
public class LoginHistory {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="user_id",nullable=false)
	private Users user;
	
	@Column(nullable=false)
	private LocalDateTime logintime;

	@Column(nullable=false)
	private InetAddress ipaddress;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
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
		return "LoginHistory [id=" + id + ", user=" + user + ", logintime=" + logintime + ", ipaddress=" + ipaddress
				+ "]";
	}
}

	
	///////.........................................................................................................................
	
	