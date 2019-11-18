package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.domain.Cliente;
import br.com.senac.service.ClienteService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/listarCliente")
	public ModelAndView listarCliente() {
		ModelAndView mv = new ModelAndView("cliente/");
		mv.addObject("clientes", clienteService.listarCliente());
		return mv;
	}
	
	@GetMapping("/adicionarCliente")
	public ModelAndView cadastrar() {
		ModelAndView mv = new ModelAndView("cliente/adicionarCliente");
		mv.addObject("cliente", new Cliente());
		
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView inserir(Cliente cliente) {
		clienteService.inserir(cliente);
		return listarCliente();
	}
	
	@GetMapping("/excluir/{id}")
	public ModelAndView delete(@PathVariable("id") Integer id) {
		clienteService.excluir(id);
		return listarCliente();
	}
	
	@GetMapping("alterarCliente/{id}")
	public ModelAndView alterar(@PathVariable("id") Integer id) throws ObjectNotFoundException{
		ModelAndView mv = new ModelAndView("cliente/alterarCliente");
		mv.addObject("cliente", clienteService.buscar(id));
		
		return mv;
	}
	
	@PostMapping("/alterarCliente")
	public ModelAndView alterar(Cliente cliente) throws ObjectNotFoundException{
		clienteService.alterar(cliente);
		return listarCliente();
	}

}
