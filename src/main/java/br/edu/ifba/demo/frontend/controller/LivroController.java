package br.edu.ifba.demo.frontend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LivroController {

    @Autowired

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @GetMapping("/form")
    public ModelAndView cadastroLivro() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("form");
        return mv;
    }

    @GetMapping("/editar")
    public ModelAndView editarLivro() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("form");
        return mv;
    }
    
}
