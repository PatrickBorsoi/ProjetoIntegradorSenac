package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.domain.ClienteDado;
import br.com.senac.service.ClienteDadoService;
import br.com.senac.service.ClienteService;
import br.com.senac.service.DadoTipoService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("/clientedado")
public class ClienteDadoController {
	
	@Autowired
	private ClienteDadoService clientedadoService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private DadoTipoService dadotipoService;
	
	@GetMapping("/listarClienteDado")
	public ModelAndView listarClienteDado() {
		ModelAndView mv = new ModelAndView("clientedado/paginaClienteDado");
		mv.addObject("clientedados", clientedadoService.listarClienteDado());
		return mv;
	}
	
	@GetMapping("/adicionarClienteDado")
	public ModelAndView cadastrar() {
		ModelAndView mv = new ModelAndView("clientedado/adicionarClienteDado");
		mv.addObject("clientedado", new ClienteDado());
		mv.addObject ("clientes", clienteService.listarCliente());
		mv.addObject("dadotipos", dadotipoService.listarDadoTipo());
		
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView inserir(ClienteDado clientedado) {
		clientedadoService.inserir(clientedado);
		return listarClienteDado();
	}
	
	@GetMapping("/excluir/{id}")
	public ModelAndView delete(@PathVariable("id") Integer id) {
		clientedadoService.excluir(id);
		return listarClienteDado();
	}
	
	@GetMapping("alterarClienteDado/{id}")
	public ModelAndView alterar(@PathVariable("id") Integer id) throws ObjectNotFoundException{
		ModelAndView mv = new ModelAndView("clientedado/alterarClienteDado");
		mv.addObject("clientedado", clientedadoService.buscar(id));
		mv.addObject ("clientes", clienteService.listarCliente());
		mv.addObject("dadotipos", dadotipoService.listarDadoTipo());
		
		return mv;
	}
	
	@PostMapping("/alterarClienteDado")
	public ModelAndView alterar(ClienteDado clientedado) throws ObjectNotFoundException{
		clientedadoService.alterar(clientedado);
		return listarClienteDado();
	}

}
