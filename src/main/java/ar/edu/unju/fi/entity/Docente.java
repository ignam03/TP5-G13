package ar.edu.unju.fi.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;


@Entity
@Table(name="docentes")
@Component
public class Docente implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5432493012199702787L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long docNumber;
	@Min(value =10000,message="El legajo debe ser mayor a 10.000")
	@Column(name="doc_legajo")
    private int legajo;
    @NotBlank(message="El nombre no puede ser vacio")
    @Column(name="doc_nombre")
    private String nombre;
    @Size(min = 3,max =15, message="El apellido debe tener entre 3 y 15 caracteres")
    @Column(name="doc_apellido")
    private String apellido;
    @NotEmpty @Email
    @Column(name="doc_email")
    private String email;
    @NotEmpty(message="El telefono no debe ser vacio")
    @Column(name="doce_telefono")
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


	public Long getDocNumber() {
		return docNumber;
	}


	public void setDocNumber(Long docNumber) {
		this.docNumber = docNumber;
	}
	
	
	

}
