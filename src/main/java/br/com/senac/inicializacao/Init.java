
package br.com.senac.inicializacao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import br.com.senac.domain.Oferta;
import br.com.senac.domain.Produto;
import br.com.senac.service.OfertaService;
import br.com.senac.service.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import
        org.springframework.context.ApplicationListener;
import
        org.springframework.context.event.ContextRefreshedEvent;
import
        org.springframework.stereotype.Component;

import br.com.senac.domain.NivelInstrucao;
import
        br.com.senac.service.NivelInstrucaoService;

@Component
public class Init implements
        ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    NivelInstrucaoService nivelService;

    @Autowired
    ProdutoService produtoService;

    @Autowired
    OfertaService ofertaService;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        NivelInstrucao nivel1 = new NivelInstrucao();
        nivel1.setDescricao("Descricao1");
        nivel1.setStatus(true);
        nivelService.save(nivel1);

        NivelInstrucao nivel2 = new NivelInstrucao();
        nivel2.setDescricao("Descricao2");
        nivel2.setStatus(false);
        nivelService.save(nivel2);

        NivelInstrucao nivel3 = new NivelInstrucao();
        nivel3.setDescricao("Descricao3");
        nivel3.setStatus(true);
        nivelService.save(nivel3);

        Produto produto1 = new Produto();
        produto1.setDescricao("Produto1 aqui");
        produto1.setNome("Produto1");
        produto1.setStatus("1");
        produto1.setNivelInstrucao(nivel1);
        produtoService.save(produto1);

        Oferta oferta1 = new Oferta();
        oferta1.setDescricao("Oferta1 aqui");
        oferta1.setProduto(produto1);
        oferta1.setPreco(new BigDecimal("2.0"));
        oferta1.setStatus(true);
        oferta1.setDataInicio("2019-02-20");
        oferta1.setDataFinal("2019-02-22");
        ofertaService.salvar(oferta1);


        List<NivelInstrucao> listaNivelInstrucoes = nivelService.searchAll();

        for (NivelInstrucao nivelInstrucao : listaNivelInstrucoes) {
            System.out.println(nivelInstrucao.getId());
        }
    }
}
