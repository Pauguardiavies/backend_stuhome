package com.stuhome.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stuhome.app.model.User;
import com.stuhome.app.service.User.UserService;

@RestController
//Va devolber formato json.
@RequestMapping("/api/usuarios")
public class userController {
	
	@Autowired
	private UserService userService;
	
	//Create a new user (Crear)
	@PostMapping
	public ResponseEntity<?> create (@RequestBody User user){
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
	}
	
	//Read an user. (Leer)
	//Tendremos que pasar un valor, para saber cual usuario queremos mostrar.
	@GetMapping("/{id}") 
	public ResponseEntity<?> read(@PathVariable(value = "id") Long userId){
		Optional<User> oUser = userService.findById(userId);
		//Exception para controlar si el id no existe.
		if(!oUser.isPresent()) {
			//Codigo: 404 not found.
			return ResponseEntity.notFound().build();
		}
		//Devolvel que todo ha ido bien. 200.
		return ResponseEntity.ok(oUser);
	}
	
	//Update an User. (Modificar)
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody User userDetails, @PathVariable (value = "id") Long userId){
		Optional<User> user = userService.findById(userId);
		//Si no esta presente. devolver codigo de error.
		if(!user.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		//Actualizar detalles de nuevo usuario.
		
		//Copia detalles que hemos pasado por userDetails, formato json, y pasarlo al objetivo user.get().
		//BeanUtils.copyProperties(userDetails, user.get());
		
		//Cogejemos los detalles del userDetails JSON, y guardamos en el user encontrado por ID.
		user.get().setName(userDetails.getName());
		user.get().setApellido(userDetails.getApellido());
		user.get().setDescription(userDetails.getDescription());
		user.get().setDireccion(userDetails.getDireccion());
		user.get().setEmail(userDetails.getEmail());
		user.get().setStudies(userDetails.getStudies());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user.get()));
		
	}
	
	//Delete an User. (Eleminar)
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id")Long userId){
		if(!userService.findById(userId).isPresent()) {
			System.out.println("No existe el usuario");
			return ResponseEntity.notFound().build();
		}
		//Eleminar usuario por defecto.
		userService.deleteById(userId);
		return ResponseEntity.ok().build();
	}
	
	//Mostrar todos los usuarios.
	//Find all users:
	@GetMapping
	public List<User> readAll(){
		
		List<User> users = StreamSupport
				.stream(userService.findAll().spliterator(), false)
				.collect(Collectors.toList()); //Nos transforme en una lista.
		
		return users;
	}
	
}
