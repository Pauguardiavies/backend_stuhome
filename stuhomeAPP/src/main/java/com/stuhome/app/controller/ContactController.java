package com.stuhome.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

import com.stuhome.app.entity.Contact;
import com.stuhome.app.entity.User;
import com.stuhome.app.service.Contact.ContactService;

@RestController
//Va devolber formato json.
@RequestMapping("/api/Contact")
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	//Create a new contact (Crear)
		@PostMapping
		public ResponseEntity<?> create (@RequestBody Contact contact){
			return ResponseEntity.status(HttpStatus.CREATED).body(contactService.save(contact));
		}
		
	//Read an contact. (Leer)
	//Tendremos que pasar un valor, para saber cual usuario queremos mostrar.
	@GetMapping("/{id}") 
	public ResponseEntity<?> read(@PathVariable(value = "id") Long contactId){
		Optional<Contact> oContact = contactService.findById(contactId);
		//Exception para controlar si el id no existe.
		if(!oContact.isPresent()) {
			//Codigo: 404 not found.
			return ResponseEntity.notFound().build();
		}
			//Devolvel que todo ha ido bien. 200.
			return ResponseEntity.ok(oContact);
	}
	
	//Update an contact. (Modificar)
		@PutMapping("/{id}")
		public ResponseEntity<?> update (@RequestBody Contact contactDetails, @PathVariable (value = "id") Long contactId){
			Optional<Contact> contact = contactService.findById(contactId);
			//Si no esta presente. devolver codigo de error.
			if(!contact.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			//Actualizar detalles de nuevo usuario.
			
			//Copia detalles que hemos pasado por userDetails, formato json, y pasarlo al objetivo user.get().
			//BeanUtils.copyProperties(userDetails, user.get());
			
			//Cogejemos los detalles del userDetails JSON, y guardamos en el user encontrado por ID.
			contact.get().setContactname(contactDetails.getContactname());
			contact.get().setEmail(contactDetails.getEmail());
			contact.get().setPhone(contactDetails.getPhone());
			contact.get().setDireccion(contactDetails.getDireccion());
			
			return ResponseEntity.status(HttpStatus.CREATED).body(contactService.save(contact.get()));
		}
		
		//Delete an contact. (Eleminar)
		@DeleteMapping("/{id}")
		public ResponseEntity<?> delete(@PathVariable(value = "id")Long contactId){
			if(!contactService.findById(contactId).isPresent()) {
				return ResponseEntity.notFound().build();
			}
			//Eleminar usuario por defecto.
			contactService.deleteById(contactId);
			return ResponseEntity.ok().build();
		}
		
		//Find all contacts:
		@GetMapping
		public List<Contact> readAll(){
			List<Contact> contact = StreamSupport
					.stream(contactService.findAll().spliterator(), false)
					.collect(Collectors.toList()); //Nos transforme en una lista.
			return contact;
		}
		
	
	
}
