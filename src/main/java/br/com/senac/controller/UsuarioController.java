package br.com.senac.controller;

import br.com.senac.domain.Usuario;
import br.com.senac.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public ModelAndView usuario(){
        ModelAndView mv = new ModelAndView("home/paginaLogin");
        mv.addObject("login", new Usuario());
        return mv;
    }

    @PostMapping("/validar")
    public  String usuario(Usuario login){
        boolean decision = usuarioService.login(login);
        if(decision)
            return "redirect:/home";
        return "404.html";
    }
}
