package ar.edu.unju.fi.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Docente {
	
	@Min(value =10000,message="El legajo debe ser mayor a 10.000")
    private int legajo;
    @NotBlank(message="El nombre no puede ser vacio")
    private String nombre;
    @Size(min = 3,max =15, message="El apellido debe tener entre 3 y 15 caracteres")
    private String apellido;
    @NotEmpty @Email
    private String email;
    @NotEmpty(message="El telefono no debe ser vacio")
    private String telefono;
	
	public Docente() {
		
	}


	public Docente(int legajo, String nombre, String apellido, String email, String telefono) {
		super();
		this.legajo = legajo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
	}


	public int getLegajo() {
		return legajo;
	}


	public void setLegajo(int legajo) {
		this.legajo = legajo;
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
