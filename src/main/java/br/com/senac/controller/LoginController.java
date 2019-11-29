package br.com.senac.controller;

import br.com.senac.domain.Login;
import br.com.senac.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView("home/paginaLogin");
        mv.addObject("login", new Login());
        return mv;
    }

    @PostMapping("/validar")
    public  String login(Login login){
        boolean decision = loginService.login(login);
        if(decision)
            return "redirect:/home";
        return "404.html";
    }
}
