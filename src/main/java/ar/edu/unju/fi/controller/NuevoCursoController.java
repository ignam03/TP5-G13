package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/curso")
public class NuevoCursoController {
    
    @GetMapping("lista_cursos")
    public String getNuevoCurso() {
        return "lista_cursos";
    }
}
