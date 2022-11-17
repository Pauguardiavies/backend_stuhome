package com.stuhome.app.service.Contact;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.stuhome.app.dao.ContactDao;
import com.stuhome.app.entity.Contact;

public interface ContactService extends ContactDao{
	
	//@return all entities sorted by the given options
		public List<Contact> findAll();
		
		//El methodo donde se puede usar la paginacion
		public Page<Contact> findAll(Pageable pageable);
		
		//Devolber optional. que nos encuentre usuarios por ID.
		public Optional<Contact> findById(Long id);
		
		//Methodo para guardar una entidad , actualizar, y va devolver el usuario.
		public Contact save(Contact contact);
		
		//Methodo para borrar un usaurio por Id.
		public void deleteById(Long id);
	
}
