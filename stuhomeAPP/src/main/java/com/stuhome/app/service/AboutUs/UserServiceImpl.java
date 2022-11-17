package com.stuhome.app.service.AboutUs;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.stuhome.app.dao.UserDao;
import com.stuhome.app.entity.Contact;
import com.stuhome.app.entity.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	//Una transaccion de solo lectura. no va cambiar el estado de BBDD
	@Transactional(readOnly = true)
	public Iterable<User> findAll() {
		
		return userDao.findAll(); //Methodo que implementa userDao.
	}

	@Override
	@Transactional(readOnly = true)
	public Page<User> findAll(Pageable pageable) {
		
		return userDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<User> findById(Long id) {
		
		return userDao.findById(id);
	}

	@Override
	@Transactional
	public User save(User user) {
		
		return userDao.save(user);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		userDao.deleteById(id);
	}

	@Override
	public Contact save(Contact contact) {
		// TODO Auto-generated method stub
		return null;
	}

}
