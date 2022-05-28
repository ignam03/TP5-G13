package ar.edu.unju.fi.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Curso;
import ar.edu.unju.fi.model.Docente;

public class ListaCurso {

    private List<Curso> cursos;

    public ListaCurso() {
        
        cursos = new ArrayList<Curso>();

		Docente docente1 = new Docente(100,"Alejandro","Sanchez","asanchez@mail.com","3884789562");
		Docente docente2 = new Docente(101,"María","Lamas","mlamas@mail.com","3884895210");
		Docente docente3 = new Docente(102,"Martina Adriana","Perez","mperez@mail.com","3884120130");
		Docente docente4 = new Docente(103,"Pedro Antonio","Miranda","pmiranda@mail.com","3884111999");

        cursos.add(new Curso(1, "Java", "desarrollo", LocalDate.of(2022, 5, 20), LocalDate.of(2022, 9, 20), 200, "virtual", docente1));
        cursos.add(new Curso(13123, "Kotlin", "desarrollo", LocalDate.of(2022, 5, 20), LocalDate.of(2022, 9, 20), 200, "virtual", docente2));
        cursos.add(new Curso(123, "Kotlin", "desarrollo", LocalDate.of(2022, 5, 20), LocalDate.of(2022, 9, 20), 200, "virtual", docente3));
        cursos.add(new Curso(24324, "Kotlin", "desarrollo", LocalDate.of(2022, 5, 20), LocalDate.of(2022, 9, 20), 200, "virtual", docente4));
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
    
    
    
}
