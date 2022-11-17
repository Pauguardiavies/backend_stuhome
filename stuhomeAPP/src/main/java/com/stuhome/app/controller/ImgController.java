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
import com.stuhome.app.entity.Img;
import com.stuhome.app.service.Img.ImgService;

@RestController
//Va devolber formato json.
@RequestMapping("/api/Img")
public class ImgController {
	
	@Autowired
	private ImgService imgService;
	
	//Find all img:
	@GetMapping
	public List<Img> readAll(){
		List<Img> img = StreamSupport
			.stream(imgService.findAll().spliterator(), false)
		.collect(Collectors.toList()); //Nos transforme en una lista.
	return img;
				}
	
}
