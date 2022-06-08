package ar.edu.unju.fi.util;

import java.util.ArrayList;
import java.util.Optional;

import ar.edu.unju.fi.entity.Docente;

public class ListaDocente {

    private ArrayList<Docente> docentes;

    public ListaDocente() {
        docentes = new ArrayList<Docente>();

        docentes.add(new Docente(3213123, "ignacio", "lopez", "ig@gmail.com", "3884798702"));
        docentes.add(new Docente(3213123, "luis", "almada", "la@gmail.com", "3884798123"));
        docentes.add(new Docente(3213123, "matias", "gallardo", "mg@gmail.com", "3884798152"));
    }

    public ListaDocente(ArrayList<Docente> docentes) {
        this.docentes = docentes;
    }

    public ArrayList<Docente> getDocentes() {
        return docentes;
    }

    public void setDocentes(ArrayList<Docente> docentes) {
        this.docentes = docentes;
    }

    public Docente findDocente(int legajo) {
        Optional<Docente> docente = getDocentes().stream().filter(d -> d.getLegajo() == legajo).findFirst();
        return docente.get();
    }

    public Docente deleteDocente(int legajo){
        Optional<Docente> docente = getDocentes().stream().filter(d -> d.getLegajo() == legajo).findFirst();
        return docente.get();
    }

}
