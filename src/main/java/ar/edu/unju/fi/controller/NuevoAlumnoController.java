package ar.edu.unju.fi.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Alumno;
import ar.edu.unju.fi.service.IAlumnoService;
import ar.edu.unju.fi.util.ListaAlumno;

@Controller
@RequestMapping("/alumno")
public class NuevoAlumnoController {

    @Autowired
    @Qualifier("AlumnoServiceImpList")
    private IAlumnoService alumnoSvc;

    private static final Log LOGGER = LogFactory.getLog(NuevoAlumnoController.class);
    ListaAlumno listaAlumnos = new ListaAlumno();

    @GetMapping("/nuevo")
    public String getFormNewAlumnoPage(Model model) {
        model.addAttribute("alumno", new Alumno());
        return "nuevo_alumno";
    }

    @PostMapping("/guardar")
    public ModelAndView getListAlumnoPage(@Validated @ModelAttribute("alumno") Alumno alumno,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView mav = new ModelAndView("nuevo_alumno");
            mav.addObject("alumno", alumno);
            LOGGER.info("error no cumple con las condiciones");
            return mav;
        }

        ModelAndView viewAlumno = new ModelAndView("lista_alumnos");
        if (alumnoSvc.compararAlumno(alumno)) {
            LOGGER.info("Error dni repetido");
        } else {
            alumnoSvc.saveAlumno(alumno);
            LOGGER.info("Se agrego un objeto al arraylist alumno");
        }
        viewAlumno.addObject("alumnos", alumnoSvc.getAlumnoLista().getAlumnos());
        return viewAlumno;
    }

    @GetMapping("/editar/{dni}")
    public ModelAndView getEditAlumnoPage(@PathVariable(value = "dni") int dni) {
        ModelAndView mav = new ModelAndView("editar_alumno");
        Alumno alumno = alumnoSvc.findAlumno(dni);
        mav.addObject("alumno", alumno);
        return mav;
    }

    @PostMapping("/modificar")
    public ModelAndView editarDatosAlumno(@Validated @ModelAttribute("alumno") Alumno alumno,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            LOGGER.info("ocurrio un error " + alumno);
            ModelAndView mav = new ModelAndView("editar_alumno");
            mav.addObject("candidato", alumno);
            return mav;
        }

        ModelAndView mav = new ModelAndView("redirect:/alumno/lista_alumnos");
        alumnoSvc.modifyAlumno(alumno);
        LOGGER.info("guardado");
        return mav;

    }

    @GetMapping("/eliminar/{dni}")
    public ModelAndView deleteCandidato(@PathVariable("dni") int dni) {
        ModelAndView movAlumos = new ModelAndView("redirect:/alumno/lista_alumnos");
        alumnoSvc.deleteAlumno(dni);
        return movAlumos;
    }

    @GetMapping("/lista_alumnos")
    public ModelAndView getListaAlumos() {
        ModelAndView movAlumos = new ModelAndView("lista_alumnos");
        movAlumos.addObject("alumnos", alumnoSvc.getAlumnoLista().getAlumnos());
        return movAlumos;
    }

}
