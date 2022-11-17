package com.stuhome.app.service.AboutUs;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.stuhome.app.entity.Contact;
import com.stuhome.app.entity.User;

public interface UserService {
	
	//@return all entities sorted by the given options
	public Iterable<User> findAll();
	
	//El methodo donde se puede usar la paginacion
	public Page<User> findAll(Pageable pageable);
	
	//Devolber optional. que nos encuentre usuarios por ID.
	public Optional<User> findById(Long id);
	
	//Methodo para guardar una entidad , actualizar, y va devolver el usuario.
	public User save(User user);
	
	public Contact save(Contact contact);
	
	//Methodo para borrar un usaurio por Id.
	public void deleteById(Long id);
	
}
