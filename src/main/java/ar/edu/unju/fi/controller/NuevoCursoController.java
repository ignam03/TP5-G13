package ar.edu.unju.fi.controller;

import java.util.Optional;

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

import ar.edu.unju.fi.entity.Curso;
import ar.edu.unju.fi.entity.Docente;
import ar.edu.unju.fi.util.ListaCurso;
import ar.edu.unju.fi.util.ListaDocente;

@Controller
@RequestMapping("/curso")
public class NuevoCursoController {

    private static final Log LOGGER = LogFactory.getLog(NuevoCursoController.class);

    @GetMapping("/nuevo")
    public String getFormNewCursoPage(Model model) {
        model.addAttribute("curso", new Curso());
        ListaDocente listaDocente = new ListaDocente();
        model.addAttribute("docentes", listaDocente.getDocentes());
        return "nuevo_curso";
    }

    @PostMapping("/guardar")
    public ModelAndView guardarCurso(@Validated @ModelAttribute("curso") Curso curso, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            LOGGER.error("No se cumplen las reglas de validacion");
            ModelAndView mov = new ModelAndView("nuevo_curso");
            mov.addObject("curso", curso);
            ListaDocente listaDocente = new ListaDocente();
            mov.addObject("docentes", listaDocente.getDocentes());
            return mov;
        }
        ModelAndView mov = new ModelAndView("lista_cursos");
        ListaCurso listaCurso = new ListaCurso();
        ListaDocente listaDocente = new ListaDocente();
        Optional<Docente> docente = listaDocente.getDocentes().stream()
                .filter(d -> d.getLegajo() == curso.getDocente().getLegajo()).findFirst();
        curso.setDocente(docente.get());
        if (listaCurso.getCursos().add(curso)) {
            LOGGER.info("Se guardo un objeto curso en la lista de cursos");
        }
        mov.addObject("cursos", listaCurso.getCursos());
        return mov;
    }

    @GetMapping("/lista_cursos")
    public String getNuevoCurso(Model model) {
        ListaCurso listaCurso = new ListaCurso();
        model.addAttribute("cursos", listaCurso.getCursos());
        return "lista_cursos";
    }
}
