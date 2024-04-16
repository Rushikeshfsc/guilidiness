package com.guielidnes.fluidscapes.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="user")
public class Users implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4952167938557332141L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="not null")
	@Column(nullable=false, unique=true)
	private String username;
	
	@NotNull(message="not null")
	//@Column(nullable=false)
	private String password;

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

	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		return Objects.equals(id, other.id) && Objects.equals(password, other.password)
				&& Objects.equals(username, other.username);
	}
	
	String user;
	private Users(String user) {
		this.user=user;
	}
	
	public String Users() {
		return user;
	}
	
	
	
}


