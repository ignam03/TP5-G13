package ar.edu.unju.fi.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/pci")
public class IndexController {
	
	
	
	@GetMapping("/inicio")
    public String getInicioPage(Model model) {
        return "index";
    }

}
