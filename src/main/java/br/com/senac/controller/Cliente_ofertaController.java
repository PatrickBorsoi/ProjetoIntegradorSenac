package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.domain.Cliente_oferta;
import br.com.senac.service.ClienteService;
import br.com.senac.service.Cliente_ofertaService;
import br.com.senac.service.Funil_etapaService;
import javassist.tools.rmi.ObjectNotFoundException;



@Controller
@RequestMapping("/clienteoferta")
public class Cliente_ofertaController {
	
	@Autowired
	Cliente_ofertaService clienteofertaservice;
	@Autowired
	Funil_etapaService funiletapaservice;
	@Autowired
	ClienteService clienteservice;
	
	/*
	@Autowired 
	OfertaService ofertaservice;
	 */

	
	@GetMapping("/listar")
	public ModelAndView listarCliente_ofertas() {
		ModelAndView mv = new ModelAndView("clienteoferta/listarClienteOferta");
		mv.addObject("clienteofertas", clienteofertaservice.searchAll());
		return mv;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarcliente_oferta() {
		ModelAndView mv = new ModelAndView("clienteoferta/cadastroClienteOferta");
		mv.addObject("clienteofertas", clienteofertaservice.searchAll());
		mv.addObject("funiletapas", funiletapaservice.searchAll());
		mv.addObject("clientes", clienteservice.searchAll());
		/* mv.addObject("ofertas", ofertaservice.searchAll()); */
		mv.addObject("clienteoferta", new Cliente_oferta());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarCliente_oferta(Cliente_oferta cliente_oferta) {
		clienteofertaservice.save(cliente_oferta);
		return listarCliente_ofertas();
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterarcliente_oferta(@PathVariable("id") Integer id) throws ObjectNotFoundException{
		ModelAndView mv = new ModelAndView("clienteoferta/alteraClienteOferta");
		mv.addObject("funiletapas", funiletapaservice.searchAll());
		mv.addObject("clientes", clienteservice.searchAll());
		mv.addObject("clienteoferta", clienteofertaservice.search(id));
		/* mv.addObject("ofertas", ofertaservice.searchAll()); */
		return mv;
		
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterarCarro(Cliente_oferta cliente_oferta) throws ObjectNotFoundException{
		clienteofertaservice.edit(cliente_oferta);
		return listarCliente_ofertas();
	}
	
	@GetMapping("/deletar/{id}")
	public ModelAndView deletarCliente_oferta(@PathVariable("id") Integer id) {
		clienteofertaservice.delete(id);
		return listarCliente_ofertas();
	}
}
