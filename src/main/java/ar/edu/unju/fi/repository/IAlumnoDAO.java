package ar.edu.unju.fi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.entity.Alumno;

public interface IAlumnoDAO extends JpaRepository<Alumno, Long>{
	
}
