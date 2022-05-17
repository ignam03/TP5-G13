package ar.edu.unju.fi.model;

import java.time.LocalDate;

public class Curso {
	
	private int codigo;
	private String titulo;
	private String categoria;
	private LocalDate fechaInicio;
	private LocalDate FechaFin;
	private int cantHoras;
	private String modalidad;
	private Docente docente;
	
	
	public Curso() {
		
	}


	public Curso(int codigo, String titulo, String categoria, LocalDate fechaInicio, LocalDate fechaFin, int cantHoras,
			String modalidad, Docente docente) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.categoria = categoria;
		this.fechaInicio = fechaInicio;
		FechaFin = fechaFin;
		this.cantHoras = cantHoras;
		this.modalidad = modalidad;
		this.docente = docente;
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
		return FechaFin;
	}


	public void setFechaFin(LocalDate fechaFin) {
		FechaFin = fechaFin;
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
