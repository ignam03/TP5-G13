package ar.edu.unju.fi.util;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Alumno;

@Component
public class ListaAlumno {

    private ArrayList<Alumno> alumnos;

    public ListaAlumno(){
        alumnos = new ArrayList<Alumno>();

        alumnos.add(new Alumno(40636205,"carlos", "madrigal", "igna@gmail.com", "3884697389" ));
        alumnos.add(new Alumno(30626205,"luisa", "bravo", "luisab@gmail.com", "3884623389" ));
    }

    public ListaAlumno(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public Alumno findAlumno(int dni){
        Optional<Alumno> alumno = getAlumnos().stream().filter(d -> d.getDni() == dni).findFirst();
        return alumno.get();
    }
    
}
