package br.com.senac.inicializacao;

import java.util.List;

import br.com.senac.domain.Oferta;
import br.com.senac.domain.Produto;
import br.com.senac.service.OfertaService;
import br.com.senac.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.senac.domain.NivelInstrucao;
import br.com.senac.service.NivelInstrucaoService;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	NivelInstrucaoService nivelService;

	@Autowired
	OfertaService ofertaService;

	@Autowired
	ProdutoService produtoService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		NivelInstrucao nivel1 = new NivelInstrucao();
		nivel1.setDescricao("Descricao1");
		nivel1.setStatus("Ativo1");
		nivelService.save(nivel1);
		
		NivelInstrucao nivel2 = new NivelInstrucao();
		nivel2.setDescricao("Descricao2");
		nivel2.setStatus("Ativo2");
		nivelService.save(nivel2);
		
		NivelInstrucao nivel3 = new NivelInstrucao();
		nivel3.setDescricao("Descricao3");
		nivel3.setStatus("Ativo3");
		nivelService.save(nivel3);

		Produto produto1 = new Produto();
		produto1.setDescricao("Teste1");
		produto1.setNome("Testando");
		produto1.setNivelInstrucao(nivel1);
		produtoService.save(produto1);


		
		List<NivelInstrucao> listaNivelInstrucoes = nivelService.searchAll();
		
		for(NivelInstrucao nivelInstrucao:listaNivelInstrucoes) {
			System.out.println(nivelInstrucao.getId());
		}	
		
	}
}
