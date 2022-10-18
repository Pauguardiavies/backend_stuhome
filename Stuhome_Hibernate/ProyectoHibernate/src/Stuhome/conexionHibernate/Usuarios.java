package Stuhome.conexionHibernate;

import javax.persistence.*;

@Entity
@Table(name="usuarios")
public class Usuarios {
	
	
	//Construcor por defecto y por parametros:
	public Usuarios() {
	}

	public Usuarios(String nombre, String apellido, int edad, String email, String username, int resenyas, int telefono,
			String direccion, String descripcion, String estudios) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.email = email;
		this.username = username;
		this.resenyas = resenyas;
		this.telefono = telefono;
		this.direccion = direccion;
		this.descripcion = descripcion;
		this.estudios = estudios;
	}
	
	
	//Getters y Setters：
	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getResenyas() {
		return resenyas;
	}

	public void setResenyas(int resenyas) {
		this.resenyas = resenyas;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstudios() {
		return estudios;
	}

	public void setEstudios(String estudios) {
		this.estudios = estudios;
	}
	
	//Mapeo ORM:

	@Id
	@Column(name="id_usuario")
	private int id_usuario;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="edad")
	private int edad;
	
	@Column(name="email")
	private String email;
	
	@Column(name="username")
	private String username;
	
	@Column(name="resenyas")
	private int resenyas;
	
	@Column(name="telefono")
	private int telefono;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="estudios")
	private String estudios;

	@Override
	public String toString() {
		return "Usuarios [id_usuario=" + id_usuario + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad
				+ ", email=" + email + ", username=" + username + ", resenyas=" + resenyas + ", telefono=" + telefono
				+ ", direccion=" + direccion + ", descripcion=" + descripcion + ", estudios=" + estudios + "]";
	}
	
}
