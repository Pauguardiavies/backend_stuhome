package com.stuhome.app.entity;

import java.io.Serializable;
import javax.persistence .*;

@Entity
@Table(name = "contact")
public class Contact implements Serializable {

	private static final long serialVersionUID = 734706639989238580L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50)
	private	String contactname;
	private String phone;
	
	//unique: no se puede aparecer dos mails iguales.
	@Column(name = "mail", length = 50, unique = true)
	private String email;
	
	private String direccion;
	
	//Contructors:
	public Contact() {
	}
	
	
	
	public Contact(String contactname, String phone, String email, String direccion) {
		this.contactname = contactname;
		this.phone = phone;
		this.email = email;
		this.direccion = direccion;
	}


	//Getters and Setters:
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContactname() {
		return contactname;
	}

	public void setContactname(String contactname) {
		this.contactname = contactname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public String toString() {
		return "Contact [id=" + id + ", contactname=" + contactname + ", phone=" + phone + ", email=" + email
				+ ", direccion=" + direccion + "]";
	}
	
	
}
