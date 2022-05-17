package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/beca")
public class NuevaBecaController {
    
    @GetMapping("/lista_becas")
    public String getNuevaBeca(){
        return "lista_becas";
    }
}
