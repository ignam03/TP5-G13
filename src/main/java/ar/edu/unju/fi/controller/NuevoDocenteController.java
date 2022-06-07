package ar.edu.unju.fi.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.util.ListaDocente;

@Controller
@RequestMapping("/docente")
public class NuevoDocenteController {

    private static final Log LOOGER = LogFactory.getLog(NuevoDocenteController.class);
    // creacion de objeto de lista docente tipo arralist
    ListaDocente listaDocentes = new ListaDocente();

    @GetMapping("/nuevo")
    public String getFormNewDocentePage(Model model) {
        model.addAttribute("docente", new Docente());
        return "nuevo_docente";
    }

    @PostMapping("/guardar")
    public ModelAndView getListaDocentePage(@Validated @ModelAttribute("docente") Docente docente,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            LOOGER.info("error al crear docente");
            ModelAndView view = new ModelAndView("nuevo_docente");

            view.addObject("docente", docente);
            return view;
        }

        ModelAndView view = new ModelAndView("lista_docentes");
        // recupera el arralist de docnetes y agregar el nuevo docente a la lista
        if (listaDocentes.getDocentes().add(docente)) {
            LOOGER.info("se agrego un objeto al arraylist docente");
        }
        // enviar el arraylist de lista docente a la pagina lista_docentes
        view.addObject("docentes", listaDocentes.getDocentes());
        return view;
    }

    @GetMapping("/lista_docentes")
    public ModelAndView getListaDocente() {
        ModelAndView movDocente = new ModelAndView("lista_docentes");
        movDocente.addObject("docentes", listaDocentes.getDocentes());
        return movDocente;
    }

    @DeleteMapping("/delete")
    public ModelAndView deleteDocente(@RequestParam(name = "legajo") int legajo) {
        ModelAndView modelAndView = new ModelAndView("lista_docentes");

        return modelAndView;
    }

}
