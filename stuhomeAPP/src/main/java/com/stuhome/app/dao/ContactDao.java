package com.stuhome.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.stuhome.app.entity.Contact;

public interface ContactDao extends JpaRepository<Contact, Long>{
	
}
