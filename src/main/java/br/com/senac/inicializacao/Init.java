/*
 * package br.com.senac.inicializacao;
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.ApplicationListener; import
 * org.springframework.context.event.ContextRefreshedEvent; import
 * org.springframework.stereotype.Component;
 * 
 * import br.com.senac.domain.NivelInstrucao; import
 * br.com.senac.service.NivelInstrucaoService;
 * 
 * @Component public class Init implements
 * ApplicationListener<ContextRefreshedEvent> {
 * 
 * @Autowired NivelInstrucaoService nivelService;
 * 
 * @Override public void onApplicationEvent(ContextRefreshedEvent event) {
 * 
 * NivelInstrucao nivel1 = new NivelInstrucao();
 * nivel1.setDescricao("Descricao1"); nivel1.setStatus("1");
 * nivelService.save(nivel1);
 * 
 * NivelInstrucao nivel2 = new NivelInstrucao();
 * nivel2.setDescricao("Descricao2"); nivel2.setStatus("1");
 * nivelService.save(nivel2);
 * 
 * NivelInstrucao nivel3 = new NivelInstrucao();
 * nivel3.setDescricao("Descricao3"); nivel3.setStatus("0");
 * nivelService.save(nivel3);
 * 
 * 
 * List<NivelInstrucao> listaNivelInstrucoes = nivelService.searchAll();
 * 
 * for(NivelInstrucao nivelInstrucao:listaNivelInstrucoes) {
 * System.out.println(nivelInstrucao.getId()); }
 * 
 * } }
 */