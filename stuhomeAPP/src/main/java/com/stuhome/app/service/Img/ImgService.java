package com.stuhome.app.service.Img;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.stuhome.app.dao.ImgDao;
import com.stuhome.app.entity.Img;

public interface ImgService extends ImgDao{
	//@return all entities sorted by the given options
	public List<Img> findAll();
			
	//El methodo donde se puede usar la paginacion
	public Page<Img> findAll(Pageable pageable);
			
	//Devolber optional. que nos encuentre usuarios por ID.
	public Optional<Img> findById(Long id);
			
	//Methodo para guardar una entidad , actualizar, y va devolver el usuario.
	public Img save(Img img);
			
	//Methodo para borrar un usaurio por Id.
	public void deleteById(Long id);
}
