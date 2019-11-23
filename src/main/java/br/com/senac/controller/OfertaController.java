package br.com.senac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.domain.Oferta;
import br.com.senac.service.OfertaService;
import br.com.senac.service.ProdutoService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("/oferta")
public class OfertaController {
	
	@Autowired
	OfertaService ofertaService;
	
	@Autowired
	ProdutoService produtoService;
	
	@GetMapping("/listar")
	public ModelAndView listaTodasOfertas() {
		ModelAndView mv = new ModelAndView("oferta/paginaOfertaTeste");
		mv.addObject("ofertas", ofertaService.buscarTodasOfertas());
		return mv;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarOferta() {
		ModelAndView mv = new ModelAndView("oferta/adicionarOfertaTeste");
		mv.addObject("produtos", produtoService.searchAll());
		mv.addObject("oferta", new Oferta());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarOferta(Oferta oferta) {
		ofertaService.salvar(oferta);
		return new ModelAndView("redirect:/oferta/listar");
	}

	@GetMapping("/alterar/{id}")
	public ModelAndView alterarOferta(@PathVariable("id") Integer idOferta) throws ObjectNotFoundException{
		ModelAndView mv = new ModelAndView("oferta/alterarOferta");
		mv.addObject("oferta", ofertaService.buscarPorID(idOferta));
		mv.addObject("produtos", produtoService.searchAll());
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterarOferta(Oferta ofertaAlterada) throws ObjectNotFoundException{
		ofertaService.salvarAlteracao(ofertaAlterada);
		return new ModelAndView("redirect:/oferta/listar");
	}
	
	@GetMapping("/deletar/{id}")
	public ModelAndView deletarOferta(@PathVariable("id") Integer id) {
		ofertaService.delete(id);
		return new ModelAndView("redirect:/oferta/listar");
	}
} 
