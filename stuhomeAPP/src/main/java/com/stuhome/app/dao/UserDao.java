package com.stuhome.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stuhome.app.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Long>{

	List<User> findByUsernameAndPassword(String username, String password);
	List<User> findByUsername(String username);
	
}
