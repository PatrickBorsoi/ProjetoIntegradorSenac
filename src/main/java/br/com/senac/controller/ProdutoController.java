package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.domain.Produto;
import br.com.senac.service.NivelInstrucaoService;
import br.com.senac.service.ProdutoService;
import javassist.tools.rmi.ObjectNotFoundException;



@Controller
@RequestMapping("produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private NivelInstrucaoService nivelService;
	
	@GetMapping("/listar")
	public ModelAndView listarProdutos() {
		ModelAndView mv = new ModelAndView("produto/listaProdutoNovo");
		mv.addObject("produtos", produtoService.searchAll());
		return mv;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarproduto() {
		ModelAndView mv = new ModelAndView("produto/cadastraProdutoNovo");
		mv.addObject("nivelInstrucoes", nivelService.searchAll());
		mv.addObject("produto", new Produto());
		return mv;
	}
	
	@GetMapping("/adicionaProduto")
	public ModelAndView salvarProduto() {
		produtoService.save(new Produto());
		return listarProdutos();
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarProduto(Produto produto) {
		produtoService.save(produto);
		return listarProdutos();
	}
	
	@GetMapping("/deletar/{id}")
	public ModelAndView deletarproduto(@PathVariable("id") Integer id) {
		produtoService.delete(id);
		return listarProdutos();
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterarproduto(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("produto/alteraProduto");
		mv.addObject("produto", produtoService.search(id));
		mv.addObject("nivelInstrucoes", nivelService.searchAll());
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Produto produto) throws ObjectNotFoundException {
		produtoService.edit(produto);
		return listarProdutos();
	}
	
}
