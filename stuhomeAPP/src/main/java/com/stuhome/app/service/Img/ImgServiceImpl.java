package com.stuhome.app.service.Img;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.stuhome.app.dao.ImgDao;
import com.stuhome.app.entity.Img;

public abstract class ImgServiceImpl implements ImgService{
	
	@Autowired
	private ImgDao imgDao;
	
	@Override
	//Una transaccion de solo lectura. no va cambiar el estado de BBDD
	@Transactional(readOnly = true)
	public List<Img> findAll() {
		return imgDao.findAll(); //Methodo que implementa userDao.
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Img> findAll(Pageable pageable) {
		return imgDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Img> findById(Long id) {
		return imgDao.findById(id);
	}

	@Override
	@Transactional
	public Img save(Img img) {
		return imgDao.save(img);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		imgDao.deleteById(id);
	}

}
