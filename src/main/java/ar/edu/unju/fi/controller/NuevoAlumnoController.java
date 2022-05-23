package ar.edu.unju.fi.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.BeanInstantiationException;

import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.util.ListaAlumno;

@Controller
@RequestMapping("/alumno")
public class NuevoAlumnoController {
    
    private static final Log LOGGER = LogFactory.getLog(NuevoAlumnoController.class);
    ListaAlumno listaAlumnos = new ListaAlumno();

    @GetMapping("/nuevo")
    public String getFormNewAlumnoPage(Model model){
        model.addAttribute("alumno", new Alumno());
        return "nuevo_alumno";
    }

    @PostMapping("/guardar")
    public ModelAndView getListAlumnoPage(@Validated @ModelAttribute("alumno")Alumno alumno, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
        	ModelAndView mav = new ModelAndView("nuevo_alumno");
        	mav.addObject("alumno", alumno);
        	return mav;
        }
    	ModelAndView viewAlumno = new ModelAndView("lista_alumnos");
        if(listaAlumnos.getAlumnos().add(alumno)){
            LOGGER.info("Se agrego un objeto al arraylist alumno");
        }
        viewAlumno.addObject("alumnos",listaAlumnos.getAlumnos());
        return viewAlumno;
    }
    
    @GetMapping("/lista_alumnos")
    public ModelAndView getListaAlumos(){
        ModelAndView movAlumos = new ModelAndView("lista_alumnos");
        movAlumos.addObject("alumnos",listaAlumnos.getAlumnos());
        return movAlumos;
    }

}
