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

import ar.edu.unju.fi.entity.Beca;
import ar.edu.unju.fi.entity.Curso;
import ar.edu.unju.fi.util.ListaBeca;
import ar.edu.unju.fi.util.ListaCurso;

@Controller
@RequestMapping("/beca")
public class NuevaBecaController {

    public static final Log LOOGER = LogFactory.getLog(NuevaBecaController.class);
    ListaBeca listaBeca = new ListaBeca();

    @GetMapping("/nueva")
    public String getNuevaBecaPage(Model model) {
        model.addAttribute("beca", new Beca());
        ListaCurso listaCurso = new ListaCurso();
        model.addAttribute("cursos", listaCurso.getCursos());
        return "nueva_beca";
    }

    @PostMapping("/guardar")
    public ModelAndView getListCursoPage(@Validated @ModelAttribute("beca") Beca beca, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            LOOGER.error("No se cumplen las reglas de validacion");
            ModelAndView view = new ModelAndView("nueva_beca");
            view.addObject("beca", beca);
            ListaCurso listaCurso = new ListaCurso();
            view.addObject("cursos", listaCurso.getCursos());
            return view;
        }

        ModelAndView view = new ModelAndView("lista_becas");
        ListaCurso listaCurso = new ListaCurso();
        Optional<Curso> curso = listaCurso.getCursos().stream()
                .filter(c -> c.getCodigo() == beca.getCurso().getCodigo()).findFirst();
        beca.setCurso(curso.get());
        if (listaBeca.getBecas().add(beca)) {
            LOOGER.info("Se agrego correctamente el objeto al arraylist becas");
        }
        view.addObject("becas", listaBeca.getBecas());
        return view;
    }

    @GetMapping("/lista_becas")
    public String getListBeca(Model model) {
        ListaBeca listaBeca = new ListaBeca();
        model.addAttribute("becas", listaBeca.getBecas());
        return "lista_becas";
    }

}
