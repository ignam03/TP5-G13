package ar.edu.unju.fi.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="becas")
@Component
public class Beca implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3940072377823358797L;
	
	@Min(value=1,message="El codigo minimo es 1")@Max(value=9999,message="El valor máximo permitido es 9999")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="bec_id")
    private int codigo;
    @NotNull(message="Debe seleccionar un curso")
    @Column(name="bec_curso")
    private Curso curso;
	@NotNull @FutureOrPresent(message="La fecha debe ser hoy o posterior")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name="bec_fechaInicio")
    private LocalDate fechaInicio;
	@NotNull @Future(message="La fecha debe ser posterior a la actual")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name="bec_fechaFin")
    private LocalDate fechaFin;
    @NotNull(message="no debe ser vacio")
	@NotEmpty(message="estado no puede ser vacío")
    @Column(name="bec_estado")
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
