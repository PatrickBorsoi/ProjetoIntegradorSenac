package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.domain.DadoTipo;
import br.com.senac.service.CategoriaDadoService;
import br.com.senac.service.DadoTipoService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("/dadotipo")
public class DadoTipoController {
	
	@Autowired
	private DadoTipoService dadotipoService;	
	
	@Autowired
	private CategoriaDadoService categoriadadoService;
	

	@GetMapping("/listarDadoTipo")
	public ModelAndView listarDadoTipo() {
		ModelAndView mv = new ModelAndView("dadotipo/paginaDadoTipo");
		mv.addObject("dadotipos",dadotipoService.listarDadoTipo()); 
		return mv;		
	}	
	
	@GetMapping("/adicionarDadoTipo")  
	public ModelAndView cadastrar() {  
		ModelAndView mv = new ModelAndView("dadotipo/adicionarDadoTipo");
		mv.addObject("categoriadados", categoriadadoService.listarCategoriaDado());
		mv.addObject("dadotipo", new DadoTipo());
		return mv;		
	}	
	
	@PostMapping("/salvar")
	public ModelAndView inserir(DadoTipo dadotipo) {
		dadotipoService.inserir(dadotipo);
		return listarDadoTipo();
	}
	
	@GetMapping("/excluir/{id}")
	public ModelAndView delete(@PathVariable("id") Integer id) {
		dadotipoService.excluir(id);
		return listarDadoTipo();	
	}	
	
	@GetMapping("/alterarDadoTipo/{id}")
		public ModelAndView alterar(@PathVariable("id") Integer id) throws ObjectNotFoundException{
		ModelAndView	mv = new ModelAndView("dadotipo/alterarDadoTipo");
		mv.addObject("dadotipo", dadotipoService.buscar(id));
		mv.addObject("categoriadados", categoriadadoService.listarCategoriaDado());
		return mv;
	}	
	
	
	@PostMapping("/alterarDadoTipo")
	public ModelAndView alterar(DadoTipo dadotipo) throws ObjectNotFoundException{
		dadotipoService.alterar(dadotipo);
		return listarDadoTipo();
	}		
	
}
