package ar.edu.unju.fi.model;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class Beca {
	
	@Min(value=100,message="El codigo debe ser mayor a 100")
    private int codigo;
    @NotEmpty
    private Curso curso;
    @Future @FutureOrPresent
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    @NotBlank(message="no debe ser vacio")
    private String estado;
	
	public Beca() {
		
	}


	public Beca(int codigo, Curso curso, LocalDate fechaInicio, LocalDate fechaFin, String estado) {
		this.codigo = codigo;
		this.curso = curso;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.estado = estado;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public Curso getCurso() {
		return curso;
	}


	public void setCurso(Curso curso) {
		this.curso = curso;
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


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	

}
