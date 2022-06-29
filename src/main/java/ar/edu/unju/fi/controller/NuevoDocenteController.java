package ar.edu.unju.fi.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

import ar.edu.unju.fi.entity.Docente;
import ar.edu.unju.fi.service.IAlumnoService;
import ar.edu.unju.fi.service.IDocenteService;
import ar.edu.unju.fi.util.ListaDocente;

@Controller
@RequestMapping("/docente")
public class NuevoDocenteController {
	
	 @Autowired
	    @Qualifier("DocenteServiceImpList")
	    private IDocenteService DocenteSvc;
	 
	 

    private static final Log LOOGER = LogFactory.getLog(NuevoDocenteController.class);
    ListaDocente listaDocentes = new ListaDocente();

    @GetMapping("/nuevo")
    public String getFormNewDocentePage(Model model) {
        model.addAttribute("docente", new Docente());
        return "nuevo_docente";
    }

    
    
    
    
	@PostMapping("/guardar")
	public ModelAndView guardarDocente(@Validated @ModelAttribute("docente") Docente docente,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			//LOGGER.info("No se cumplen las validaciones");
			ModelAndView mov = new ModelAndView("nuevo_docente");
			return mov;

		}
		ModelAndView mov = new ModelAndView("lista_docentes");

		DocenteSvc.saveDocente(docente);
		mov.addObject("inicio");
		return mov;
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
