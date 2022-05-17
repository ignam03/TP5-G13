package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("pci")
public class AgendaController {
	
	@GetMapping("/agenda")
    public String getAgendaPage(Model model) {

        //Alumno unAlumno = new Alumno(40636205,"carlos","madrigal","igna@gmail.com",388469789);
        //model.addAttribute("alumno", unAlumno);
        return "agenda";
    }

}
