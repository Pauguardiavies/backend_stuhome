package com.stuhome.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "img")
public class Img implements Serializable{
	
	private static final long serialVersionUID = 3806836784015111276L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 100)
	private	String rutaImg;

	//Constructor IMG
	public Img(Long id, String rutaImg) {
		this.id = id;
		this.rutaImg = rutaImg;
	}

	//Getters and Setters
	public Img() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRutaImg() {
		return rutaImg;
	}

	public void setRutaImg(String rutaImg) {
		this.rutaImg = rutaImg;
	}

	@Override
	public String toString() {
		return "Img [id=" + id + ", rutaImg=" + rutaImg + "]";
	}
}
