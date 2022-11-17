package com.stuhome.app.service.Contact;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import com.stuhome.app.dao.ContactDao;
import com.stuhome.app.entity.Contact;

public abstract class ContactServiceImpl implements ContactService{
	
	@Autowired
	private ContactDao contactDao;
	
	@Override
	//Una transaccion de solo lectura. no va cambiar el estado de BBDD
	@Transactional(readOnly = true)
	public List<Contact> findAll() {
		return contactDao.findAll(); //Methodo que implementa userDao.
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Contact> findAll(Pageable pageable) {
		return contactDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Contact> findById(Long id) {
		return contactDao.findById(id);
	}

	@Override
	@Transactional
	public Contact save(Contact contact) {
		return contactDao.save(contact);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		contactDao.deleteById(id);
	}

}
