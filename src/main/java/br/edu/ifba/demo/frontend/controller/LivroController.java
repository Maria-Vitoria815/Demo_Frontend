package br.edu.ifba.demo.frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import br.edu.ifba.demo.frontend.service.LivroService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import br.edu.ifba.demo.frontend.dto.LivroDTO;

@Controller
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping("/")
    public ModelAndView index() {
        String valor = livroService.listAllLivros().toString();
        ModelAndView mv = new ModelAndView();
        mv.addObject("teste", valor);
        mv.setViewName("index");
        return mv;
    }

 
    @PostMapping("/livro/save")
    public String save(@ModelAttribute LivroDTO livroDTO) {
        livroService.save(livroDTO); 
        return "redirect:/livro/listall"; 
    }

   
     @GetMapping("/livro/listall")
     public ModelAndView livros() {
        List<LivroDTO> li = livroService.listAllLivros();
        ModelAndView mv = new ModelAndView();
        mv.addObject("listaLivros", li);
        mv.setViewName("index");
        return mv;
    }
   

  
@GetMapping("/livro/titulo/{titulo}")
public ModelAndView getByTitulo(@PathVariable("titulo") String titulo) {
    LivroDTO livro1 = livroService.getByTitulo(titulo);
    ModelAndView mv = new ModelAndView();
    if (livro1 != null) {
        mv.addObject("listaLivros", List.of(livro1));
    } else {
        mv.addObject("errorMessage", "Este livro não foi encontrado :(");
    }
    mv.setViewName("index");
    return mv;
}

        
@GetMapping("/livro/isbn/{isbn}")
public ModelAndView getByIsbn(@PathVariable("isbn") String isbn) {
            LivroDTO livro2 = livroService.getByIsbn(isbn);
            ModelAndView mv = new ModelAndView();
            mv.addObject("livro.isbn", livro2);
            mv.setViewName("index");
            return mv;
        }


        @GetMapping("/livro/id/{id}")
        public ModelAndView getById(@PathVariable("id") Long id) {
            LivroDTO livro = livroService.getById(id);
            ModelAndView mv = new ModelAndView();
            if (livro != null) {
                mv.addObject("listaLivros", List.of(livro)); 
            } else {
                mv.addObject("errorMessage", "Este livro não foi encontrado :(");
            }
            mv.setViewName("index");
            return mv;
        }
        
        
     @GetMapping("/livro/delete/{id}")
     public String delete(@RequestParam("id") Long id) {
        livroService.delete(id);
        return "redirect:/livro/listall";
        }
    
}
