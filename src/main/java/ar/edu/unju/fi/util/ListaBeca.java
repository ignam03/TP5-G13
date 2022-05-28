package ar.edu.unju.fi.util;

import java.time.LocalDate;
import java.util.ArrayList;


import ar.edu.unju.fi.model.Beca;
import ar.edu.unju.fi.model.Curso;
import ar.edu.unju.fi.model.Docente;

public class ListaBeca {

	private ArrayList<Beca> becas;

	public ListaBeca() {
		becas = new ArrayList<Beca>();

		Docente docente1 = new Docente(100,"Alejandro","Sanchez","asanchez@mail.com","3884789562");

		Curso curso1 = (new Curso(1, "Kotlin", "desarrollo", LocalDate.of(2022, 5, 20), LocalDate.of(2022, 9, 20), 200, "virtual", docente1));

		becas.add(new Beca(1234, curso1, LocalDate.of(2022, 5, 28), LocalDate.of(2022, 7, 1), "estado"));
	}

	public ListaBeca(ArrayList<Beca> becas) {
		this.becas = becas;
	}

	public ArrayList<Beca> getBecas() {
		return becas;
	}

	public void setBecas(ArrayList<Beca> becas) {
		this.becas = becas;
	}

}
