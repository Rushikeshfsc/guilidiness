package com.guielidnes.fluidscapes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guielidnes.fluidscapes.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{

	//Adminlogin finbyUsername(String username, String password);
	Users findByUsername(String username);
	

}
