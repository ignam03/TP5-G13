package ar.edu.unju.fi.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;


@Entity
@Table(name="cursos")
@Component
public class Curso implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2873480347854716142L;
	
	@Min(value=1, message="El valor mínimo es 1") @Max(value=9999,message="El valor máximo permitido es 9999")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cur_id")
	private int codigo;
	@NotEmpty(message="El título no puede ser vacío")
	@Column(name="cur_titulo")
	private String titulo;
	@NotEmpty(message="Categoría no puede ser vacío")
	@Column(name="cur_categoria")
	private String categoria;
	@NotNull @FutureOrPresent(message="La fecha debe ser hoy o posterior")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name="cur_fechaInicio")
	private LocalDate fechaInicio;
	@NotNull @Future(message="La fecha debe ser posterior a la actual")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name="cur_fechaFin")
	private LocalDate fechaFin;
	@Min(value=1,message="Cantidad de horas debe ser mayor a 1")
	@Column(name="cur_cantHoras")
	private int cantHoras;
	@NotEmpty(message="Modalidad no puede ser vacío")
	@Column(name="curs_modalidad")
	private String modalidad;
	@NotNull(message="Debe seleccionar un docente")
	@Column(name="cur_docente")
	private Docente docente;
	//@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@OneToOne(mappedBy = "curso",fetch = FetchType.LAZY)
	private Alumno alumnos;

	@OneToMany(mappedBy = "curso",cascade = CascadeType.ALL)
	private List<Beca> becas =new ArrayList<Beca>();
	
	



	public Curso() {
		
	}
	


	public Curso(int codigo, String titulo, String categoria, LocalDate fechaInicio, LocalDate fechaFin, int cantHoras,
			String modalidad, Docente docente) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.categoria = categoria;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.cantHoras = cantHoras;
		this.modalidad = modalidad;
		this.docente = docente;
	}
	public List<Beca> getBecas() {
		return becas;
	}



	public void setBecas(List<Beca> becas) {
		this.becas = becas;
	}

	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public LocalDate getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}



	public LocalDate getFechaFin() {
		return fechaFin;
	}


	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}


	public int getCantHoras() {
		return cantHoras;
	}


	public void setCantHoras(int cantHoras) {
		this.cantHoras = cantHoras;
	}


	public String getModalidad() {
		return modalidad;
	}


	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}


	public Docente getDocente() {
		return docente;
	}


	public void setDocente(Docente docente) {
		this.docente = docente;
	}
	
	
	

}
