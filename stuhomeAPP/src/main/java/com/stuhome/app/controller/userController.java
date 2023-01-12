package com.stuhome.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.apache.commons.codec.digest.DigestUtils;
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
@RequestMapping("/api/users")
public class userController {
	
	@Autowired
	private UserService userService;
	
	//Create a new user (Crear) Signin
	@PostMapping("/signin")
	public ResponseEntity<?> create (@RequestBody User user){
		//Almacenar la contraseña cifrada usando la clase DigestUtils.
		String pass=user.getPassword();
	    String passCifrada=DigestUtils.md5Hex(pass);
	    user.setPassword(passCifrada);
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
	}
	
	//Read an user (Leer) Login
	@PostMapping("/login")
	public ResponseEntity<?> read (@RequestBody User user){
		//Buscar el nombre de usuario si exise o no.
		//Ciframos la contraseña que hemos introducido y comparalo con el de BBDD.
		String pass=user.getPassword();
	    String passCifrada=DigestUtils.md5Hex(pass);
		List<User> lUser = userService.findByUsernameAndPassword(user.getUsername(),passCifrada);
		System.out.println(lUser);
		//Si encuentra el nombre de usuario y la contraseña esta correcta.
		if(!lUser.isEmpty())
			//Devolvel que todo ha ido bien. 200.
			return ResponseEntity.ok(lUser);
		//Si no encuentra, pues 404 not found.
		return ResponseEntity.notFound().build();
	}
	
	//Update user password: (Actualizar contraseña del usuario)
		@PutMapping("/changeUserPwd")
		public ResponseEntity<?> update (@RequestBody User user){
			
			List<User> lUser = userService.findByUsername(user.getUsername());
			//Si existe el username, pues podriamos cambiar el password.
			if(lUser.isEmpty())
			{
				System.err.println("No se ha encontrado el usuario.");
				//Devolver 404 not found.
				return ResponseEntity.notFound().build();
			}
				//Ciframos la contraseña introducida y guardamos en BBDD.
				String pass=user.getPassword();
			    String passCifrada=DigestUtils.md5Hex(pass);
			    //Lo actulizamos en ese usuario.
			    lUser.get(0).setPassword(passCifrada);
			    System.out.println("Contraseña actualizada correctamente.");
			    return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(lUser.get(0)));
		}
		
	//Delete User: (Eleminar un usuario y dar baja el usuario en el aplicacion)
		@DeleteMapping("/user")
		public ResponseEntity<?> deleteUser (@RequestBody User user){
			List<User> lUser = userService.findByUsername(user.getUsername());
			//Si existe el username, pues eleminamos ese usuario.
			if(lUser.isEmpty())
			{
				System.err.println("No se ha encontrado el usuario.");
				//Devolver 404 not found.
				return ResponseEntity.notFound().build();
			}
			userService.deleteById(lUser.get(0).getId());
			System.out.println("Hemos eleminado el usuario" + lUser.get(0).getUsername());
			return ResponseEntity.ok().build();
		}
	
	//Muestra información de perfil de usuario almacenada en la BBDD
		@GetMapping("/profile/{idUser}") 
		public ResponseEntity<?> read(@PathVariable(value = "idUser") Long userId){
			Optional<User> oUser = userService.findById(userId);
			//Exception para controlar si el id no existe.
			if(!oUser.isPresent()) {
				//Codigo: 404 not found.
				return ResponseEntity.notFound().build();
			}
			//Devolvel que todo ha ido bien. 200.
			
			return ResponseEntity.ok("Nombre: "+oUser.get().getName()+
			"\n" + "Apellido: " + oUser.get().getApellido() + 
			"\n" + "Description: " + oUser.get().getDescription() +
			"\n" + "Direction: " + oUser.get().getDireccion() +
			"\n" + "Email: " + oUser.get().getEmail() + 
			"\n" + "Estudios: " + oUser.get().getStudies());
		}
	//Editar el perfil del usuario:
		@PutMapping("/profile")
		public ResponseEntity<?> updateProfile (@RequestBody User user){
			List<User> lUser = userService.findByUsername(user.getUsername());
			//Si existe el username, pues podriamos editar el perfil del usuario.
			if(lUser.isEmpty())
			{
				System.err.println("No se ha encontrado el usuario.");
				//Devolver 404 not found.
				return ResponseEntity.notFound().build();
			}
			//Cogemos los datos del body y lo guardamos en BBDD.
			lUser.get(0).setName(user.getName());
			lUser.get(0).setApellido(user.getApellido());
			lUser.get(0).setDescription(user.getDescription());
			lUser.get(0).setDireccion(user.getDireccion());
			lUser.get(0).setEmail(user.getEmail());
			lUser.get(0).setStudies(user.getStudies());
			return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(lUser.get(0)));
		}
		
	//-------------------------------------------------------------------------------------------------
	
	//Read an user. (Leer)
	//Tendremos que pasar un valor, para saber cual usuario queremos mostrar.
//	@GetMapping("/{id}") 
//	public ResponseEntity<?> read(@PathVariable(value = "id") Long userId){
//		Optional<User> oUser = userService.findById(userId);
//		//Exception para controlar si el id no existe.
//		if(!oUser.isPresent()) {
//			//Codigo: 404 not found.
//			return ResponseEntity.notFound().build();
//		}
//		//Devolvel que todo ha ido bien. 200.
//		return ResponseEntity.ok(oUser);
//	}
	
	//Update an User. (Modificar)
//	@PutMapping("/{id}")
//	public ResponseEntity<?> update (@RequestBody User userDetails, @PathVariable (value = "id") Long userId){
//		Optional<User> user = userService.findById(userId);
//		//Si no esta presente. devolver codigo de error.
//		if(!user.isPresent()) {
//			return ResponseEntity.notFound().build();
//		}
//		//Actualizar detalles de nuevo usuario.
//		//Copia detalles que hemos pasado por userDetails, formato json, y pasarlo al objetivo user.get().
//		//BeanUtils.copyProperties(userDetails, user.get());
//		
//		//Cogejemos los detalles del userDetails JSON, y guardamos en el user encontrado por ID.
//		user.get().setName(userDetails.getName());
//		user.get().setApellido(userDetails.getApellido());
//		user.get().setDescription(userDetails.getDescription());
//		user.get().setDireccion(userDetails.getDireccion());
//		user.get().setEmail(userDetails.getEmail());
//		user.get().setStudies(userDetails.getStudies());
//		
//		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user.get()));
//		
//	}

	//Delete an User. (Eleminar)
//	@DeleteMapping("/{id}")
//	public ResponseEntity<?> delete(@PathVariable(value = "id")Long userId){
//		if(!userService.findById(userId).isPresent()) {
//			System.out.println("No existe el usuario");
//			return ResponseEntity.notFound().build();
//		}
//		//Eleminar usuario por defecto.
//		userService.deleteById(userId);
//		return ResponseEntity.ok().build();
//	}
	
	//Mostrar todos los usuarios.
	//Find all users:
//	@GetMapping
//	public List<User> readAll(){
//		
//		List<User> users = StreamSupport
//				.stream(userService.findAll().spliterator(), false)
//				.collect(Collectors.toList()); //Nos transforme en una lista.
//		
//		return users;
//	}
	
}
