package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.domain.Funil_etapa;
import br.com.senac.service.Funil_etapaService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("funiletapa")
public class Funil_etapaController {
	
	@Autowired
	private Funil_etapaService funilService;
	
	@GetMapping("/listar")
	public ModelAndView listarFunil_etapas() {
		ModelAndView mv = new ModelAndView("funiletapa/listaFuniletapa");
		mv.addObject("funiletapas", funilService.searchAll());
		return mv;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarFunil_etapa() {
		ModelAndView mv = new ModelAndView("funiletapa/cadastraFuniletapa");
		mv.addObject("funiletapa", new Funil_etapa());
		return mv;
	}
	
	@GetMapping("/adicionaFuniletapa")
	public ModelAndView salvarFunil_etapa() {
		funilService.save(new Funil_etapa());
		return listarFunil_etapas();
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarfunil_etapa(Funil_etapa funil_etapa) {
		funilService.save(funil_etapa);
		return listarFunil_etapas();
	}
	
	@GetMapping("/deletar/{id}")
	public ModelAndView deletarfunil_etapa(@PathVariable("id") Integer id) {
		funilService.delete(id);
		return listarFunil_etapas();
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterarFunil_etapa(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("funiletapa/alteraFuniletapa");
		mv.addObject("funiletapa", funilService.search(id));
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Funil_etapa funil_etapa) throws ObjectNotFoundException {
		funilService.edit(funil_etapa);
		return listarFunil_etapas();
	}
	

}
