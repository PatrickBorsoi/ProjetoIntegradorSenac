package br.com.senac.controller;

import br.com.senac.domain.Acao;
import br.com.senac.service.AcaoService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/acao")
public class AcaoController {
        @Autowired
        private AcaoService acaoService;

        @GetMapping("/listar")
        public ModelAndView listarAcao() {
            ModelAndView mv = new ModelAndView("Acao/listaAcao");
            mv.addObject("acoes", acaoService.ProcurarTodasAcoes());
            return mv;
        }

        @GetMapping("/cadastrar")
        public ModelAndView cadastrarAcao() {
            ModelAndView mv = new ModelAndView("Acao/cadastraAcao");
            mv.addObject("acao", new Acao());
            return mv;
        }

        @GetMapping("/adicionaAcao")
        public ModelAndView salvarAcao() {
            acaoService.salvar(new Acao());
            return listarAcao();
        }

        @PostMapping("/salvar")
        public ModelAndView salvarAcao(Acao Acao) {
            acaoService.salvar(Acao);
            return new ModelAndView("redirect:/acao/listar");
        }

        @GetMapping("/deletar/{id}")
        public ModelAndView deletarAcao(@PathVariable("id") Integer id) {
            acaoService.delete(id);
            return new ModelAndView("redirect:/acao/listar");
        }

        @GetMapping("/alterar/{id}")
        public ModelAndView alterarAcao(@PathVariable("id") Integer id) throws ObjectNotFoundException {
            ModelAndView mv = new ModelAndView("acao/alteraAcao");
            mv.addObject("acao", acaoService.ProcurarPorId(id));
            return mv;
        }

        @PostMapping("/alterar")
        public ModelAndView alterar(Acao Acao) throws ObjectNotFoundException {
            acaoService.editar(Acao);
            return new ModelAndView("redirect:/acao/listar");
        }
}
