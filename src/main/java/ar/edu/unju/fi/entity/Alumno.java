package ar.edu.unju.fi.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Entity
@Table(name="alumnos")
@Component
public class Alumno implements Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 3297184743700349336L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long aluNumber;
	@Min(value=1000000,message="El DNI debe ser mayor a 1.000.000")
	@Column(name="alu_dni")
	private int dni;
	@Size(min=3, max=20, message="El nombre debe tener entre 3 a 20 caracteres")
	@NotEmpty(message="El nombre del alumno no puede ser vacio")
	@Column(name="alu_nombre")
	private String nombre;
	@NotBlank(message="El apellido del alumno no puede ser blanco")
	@Column(name="alu_apellido")
	private String apellido;
	@NotEmpty @Email
	@Column(name="alu_email")
	private String email;
	@Size(min=5, max=10) @NotEmpty(message="El telefono no puede ser vacío")
	@Column(name="alu_telefono")
	private String telefono;
	
	@OneToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="curso_ID")
	private Curso curso;
	

	

	public Alumno() {
		
	}


	public Alumno(int dni, String nombre, String apellido, String email, String telefono) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
	}
	public Curso getCurso() {
		return curso;
	}


	public void setCurso(Curso curso) {
		this.curso = curso;
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


	public Long getAluNumber() {
		return aluNumber;
	}


	public void setAluNumber(Long aluNumber) {
		this.aluNumber = aluNumber;
	}
	
	
	
}
