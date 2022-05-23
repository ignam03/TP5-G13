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

import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.util.ListaBeca;

@Controller
@RequestMapping("/beca")
public class NuevaBecaController {
    
    @GetMapping("/lista_becas")
    public String getNuevaBeca(){
        return "lista_becas";
    }

    private static final Log LOGGER = LogFactory.getLog(NuevoAlumnoController.class);
    ListaBeca listaBeca = new ListaBeca();
    //TENEMOS QUE ARREGLAR EL LocalDate DE LA CLASE BECAS
	/*
	 * @PostMapping("/guardar") public ModelAndView
	 * getListBecaPage(@Validated @ModelAttribute("Beca")ListaBeca Beca,
	 * BindingResult bindingResult){ if(bindingResult.hasErrors()) { ModelAndView
	 * mav = new ModelAndView("nueva_becas"); mav.addObject("beca", Beca); return
	 * mav; } ModelAndView viewBecas = new ModelAndView("lista_becas");
	 * if(listaBeca.getBecas().add(Beca)){
	 * LOGGER.info("Se agrego un objeto al arraylist becas"); }
	 * viewBecas.addObject("Beca",listaBeca.getBecas()); return viewBecas; }
	 * 
	 * @GetMapping("/lista_becas") public ModelAndView getListaBecas(){ ModelAndView
	 * movBecas = new ModelAndView("lista_becas");
	 * movBecas.addObject("Beca",listaBeca.getBecas()); return movBecas; }
	 */}
