package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.domain.CategoriaDado;
import br.com.senac.service.CategoriaDadoService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("/categoriadado")
public class CategoriaDadoController {
	
	@Autowired
	private CategoriaDadoService categoriadadoService;
	
	@GetMapping("/listarCategoriaDado")
	public ModelAndView listarCategoriaDado() {
		ModelAndView mv = new ModelAndView("categoriadado/paginaCategoriaDado");
		mv.addObject("categoriadados", categoriadadoService.listarCategoriaDado());
		return mv;
	}
	
	@GetMapping("/adicionarCategoriaDado")
	public ModelAndView cadastrar() {
		ModelAndView mv = new ModelAndView("categoriadado/adicionarCategoriaDado");
		mv.addObject("categoriadado", new CategoriaDado());
		
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView inserir(CategoriaDado categoriadado) {
		categoriadadoService.inserir(categoriadado);
		return listarCategoriaDado();
	}
	
	@GetMapping("/excluir/{id}")
	public ModelAndView delete(@PathVariable("id") Integer id) {
		categoriadadoService.excluir(id);
		return listarCategoriaDado();
	}
	
	@GetMapping("alterarCategoriaDado/{id}")
	public ModelAndView alterar(@PathVariable("id") Integer id) throws ObjectNotFoundException{
		ModelAndView mv = new ModelAndView("categoriadado/alterarCategoriaDado");
		mv.addObject("categoriadado", categoriadadoService.buscar(id));
		
		return mv;
	}
	
	@PostMapping("/alterarCategoriaDado")
	public ModelAndView alterar(CategoriaDado categoriadado) throws ObjectNotFoundException{
		categoriadadoService.alterar(categoriadado);
		return listarCategoriaDado();
	}

}
