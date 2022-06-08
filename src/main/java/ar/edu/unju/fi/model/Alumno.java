package ar.edu.unju.fi.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;


@Component
public class Alumno {

	@Min(value=1000000,message="El DNI debe ser mayor a 1.000.000")
	private int dni;
	@Size(min=3, max=20, message="El nombre debe tener entre 3 a 20 caracteres")
	@NotEmpty(message="El nombre del alumno no puede ser vacio")
	private String nombre;
	@NotBlank(message="El apellido del alumno no puede ser blanco")
	private String apellido;
	@NotEmpty @Email
	private String email;
	@Size(min=5, max=10) @NotEmpty(message="El telefono no puede ser vacío")
	private String telefono;
	
	
	public Alumno() {
		
	}


	public Alumno(int dni, String nombre, String apellido, String email, String telefono) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
	}


	public int getDni() {
		return dni;
	}


	public void setDni(int dni) {
		this.dni = dni;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	
}
