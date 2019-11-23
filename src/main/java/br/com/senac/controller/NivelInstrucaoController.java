package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.domain.NivelInstrucao;
import br.com.senac.service.NivelInstrucaoService;
import javassist.tools.rmi.ObjectNotFoundException;



@Controller
@RequestMapping("nivelInstrucao")
public class NivelInstrucaoController {
	
	@Autowired
	private NivelInstrucaoService nivelIService;
	
	@GetMapping("/listar")
	public ModelAndView listarNivelInstrucoes() {
		ModelAndView mv = new ModelAndView("nivelInstrucao/listaNivelInstrucaoNovo");
		mv.addObject("nivelInstrucoes", nivelIService.searchAll());
		return mv;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarNivelInstrucao() {
		ModelAndView mv = new ModelAndView("nivelInstrucao/cadastraNivelInstrucaoNovo");
		mv.addObject("nivelInstrucao", new NivelInstrucao());
		return mv;
	}
	
	@GetMapping("/adicionaNivelInstrucao")
	public ModelAndView salvarNivelInstrucao() {
		nivelIService.save(new NivelInstrucao());
		return listarNivelInstrucoes();
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarnivelInstrucao(NivelInstrucao nivelInstrucao) {
		nivelIService.save(nivelInstrucao);
		return listarNivelInstrucoes();
	}
	
	@GetMapping("/deletar/{id}")
	public ModelAndView deletarnivelInstrucao(@PathVariable("id") Integer id) {
		nivelIService.delete(id);
		return listarNivelInstrucoes();
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterarNivelInstrucao(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("nivelInstrucao/alteraNivelInstrucaoNovo");
		mv.addObject("nivelInstrucao", nivelIService.search(id));
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(NivelInstrucao nivelInstrucao) throws ObjectNotFoundException {
		nivelIService.edit(nivelInstrucao);
		return listarNivelInstrucoes();
	}

}
