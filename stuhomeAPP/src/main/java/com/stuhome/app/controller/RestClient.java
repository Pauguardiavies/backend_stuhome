package com.stuhome.app.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.stuhome.app.model.User;

public class RestClient {

	//Endpoints: CRUD (Create, Read, Update, Delete).
	private static final String GET_ALL_USER_API = "http://localhost:8080/api/usuarios";
	private static final String GET_USER_BY_ID_API = "http://localhost:8080/api/usuarios/{id}";
	private static final String CREATE_USER_API = "http://localhost:8080/api/usuarios";
	private static final String UPDATE_USER_API = "http://localhost:8080/api/usuarios/{id}";
	private static final String DELETE_USER_API = "http://localhost:8080/api/usuarios/{id}";
	
	static RestTemplate restTemplate = new RestTemplate();
	
	//Realizar comprobaciones:
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestClient restClientAPI = new RestClient();
		
		//Mostrar todos los usuarios de BBDD.
		//restClientAPI.getAllUsersAPI();
		
		//Mostrar usuario por ID.
		//restClientAPI.getUserById();
		
		//Methodo para crear usuarios:
		//restClientAPI.createUserAPI();
		
		//Methodo para actualizarUsuario por id:
		restClientAPI.updateUserAPI();
	}
	
	//Methodo para mostrar todos los usaurios. (Read)
	private void getAllUsersAPI() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity <String> entity = new HttpEntity <String> ("parameters", headers);
		
		ResponseEntity<String> result = restTemplate.exchange(GET_ALL_USER_API, HttpMethod.GET,entity,String.class);
		System.out.println(result);
	}
	
	//Methodo mostrar usuario por ID: (Read)
	private void getUserById() {
		 Map < String, String > params = new HashMap < String, String > ();
		 params.put("id", "1");
		 RestTemplate restTemplate = new RestTemplate();
	     User user = restTemplate.getForObject(GET_USER_BY_ID_API, User.class, params);
	     
	     System.out.println("ID: " + user.getId() + "\nNombre: " + user.getName() + 
	    "\nApellido: " + user.getApellido() + "\nEstudios: " + user.getStudies());
	}
	
	//Methodo para crear usuarios: (Create)
	private void createUserAPI() {
		User user = new User("Pau","Guardia","pauGuardia3@gmail.com",
		"Estudiante Grado Superior en Desarrollo de Aplicaciones","Hospitalet","Informe tecnico");
		ResponseEntity<User> newuser = restTemplate.postForEntity(CREATE_USER_API, user, User.class);
		System.out.println(newuser.getBody());
	}
	
	//Methodo para actualizar usuarios de BBDD: (Update)
	private void updateUserAPI() {
		Map<String, Integer> param = new HashMap < String, Integer > ();
		 param.put("id", 1);
		 User updateUser = new User("David","Elias","DavidElias@gmail.com",
		"Estudiante Grado Superior en Desarrollo de Aplicaciones","Hospitalet","Informe tecnico");
		 ResponseEntity<User> newuser = restTemplate.postForEntity(UPDATE_USER_API, updateUser, User.class);
		 System.out.println(newuser);
	}
	
	//Methodo para eleminar usuarios: (Delete)
	private void deleteUserAPI() {
		Map<String, Integer> param = new HashMap<>();
		param.put("id", 1);
		restTemplate.delete(DELETE_USER_API,param);
	}

}
