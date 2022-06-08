package ar.edu.unju.fi.service;

import ar.edu.unju.fi.entity.Alumno;
import ar.edu.unju.fi.util.ListaAlumno;

public interface IAlumnoService {
	
    public Boolean saveAlumno(Alumno alumno);
    public void modifyAlumno(Alumno alumno);
    public void deleteAlumno(int dni);
    public ListaAlumno getAlumnoLista();
    public Alumno findAlumno(int dni);
    public Boolean compararAlumno(Alumno alumno);

}