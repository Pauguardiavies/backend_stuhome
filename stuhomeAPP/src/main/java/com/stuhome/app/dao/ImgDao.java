package com.stuhome.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.stuhome.app.entity.Img;

public interface ImgDao extends JpaRepository<Img, Long>{
	
}
