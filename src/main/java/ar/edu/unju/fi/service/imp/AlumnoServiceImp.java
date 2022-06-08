
package ar.edu.unju.fi.service.imp;

import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.service.IAlumnoService;
import ar.edu.unju.fi.util.ListaAlumno;

@Service("AlumnoServiceImpList")
public class AlumnoServiceImp implements IAlumnoService{

    @Autowired
    private ListaAlumno listaAlumnos;

    private static final Log LOGGER = LogFactory.getLog(AlumnoServiceImp.class);

    @Override
    public Boolean saveAlumno(Alumno alumno){
        return listaAlumnos.getAlumnos().add(alumno);
    }

    @Override
    public void modifyAlumno(Alumno alumno){
        for(Alumno alum : listaAlumnos.getAlumnos()){
            if(alum.getDni() == alumno.getDni()){
                alum.setNombre(alumno.getNombre());
                alum.setApellido(alumno.getApellido());
                alum.setEmail(alumno.getEmail());
                alum.setTelefono(alumno.getTelefono());
            }
        }
    }

    @Override
    public void deleteAlumno(int dni){
        Optional<Alumno> alumno = listaAlumnos.getAlumnos().stream().filter(a -> a.getDni() == dni).findFirst();
        listaAlumnos.getAlumnos().remove(alumno.get());
    }

    @Override
    public ListaAlumno getAlumnoLista(){
        return listaAlumnos;
    }

    @Override
    public Alumno findAlumno(int dni){
        Optional<Alumno> alumno = listaAlumnos.getAlumnos().stream().filter(a->a.getDni()==dni).findFirst();
        return alumno.get();
    }

    public Boolean compararAlumno(Alumno alumno){
        boolean band= false;
        for(Alumno almn : listaAlumnos.getAlumnos()){
            if(almn.getDni()== alumno.getDni()){
                LOGGER.info("se repite el dni");
                band=true;
            }
        }
        return band;
    }
}