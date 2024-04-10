package com.guielidnes.fluidscapes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guielidnes.fluidscapes.entity.LoginHistory;

@Repository
public interface LoginDetailRepository extends JpaRepository<LoginHistory, Long> {

	//List<Loginhistory> getall(String date,String ipaddress);
}
