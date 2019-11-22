package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/* teste*/

import br.com.senac.domain.Cliente_oferta;
import br.com.senac.repository.Cliente_ofertaRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class Cliente_ofertaService {
	
	@Autowired 
	Cliente_ofertaRepository clienteOrepository;
	
	public Cliente_oferta search(Integer id) throws ObjectNotFoundException{
		Optional<Cliente_oferta> cliente_oferta = clienteOrepository.findById(id);
		
		return cliente_oferta.orElseThrow(() -> new ObjectNotFoundException(" não encontrado. id: " + id+ ", Tipo!"+ Cliente_oferta.class.getName()));
		
	}
	public List<Cliente_oferta> searchAll(){
		return clienteOrepository.findAll();
	}
	
	public Cliente_oferta save(Cliente_oferta cliente_oferta) {
		return clienteOrepository.save(cliente_oferta);
	}
	
	public List<Cliente_oferta> saveAll(List<Cliente_oferta> cliente_ofertas){
		return clienteOrepository.saveAll(cliente_ofertas);
	}
	
	public Cliente_oferta edit (Cliente_oferta cliente_oferta) throws ObjectNotFoundException{
		Cliente_oferta cliente_ofertaAntigo = search(cliente_oferta.getId());
		cliente_ofertaAntigo.setId(cliente_oferta.getId());
		cliente_ofertaAntigo.setPreco(cliente_oferta.getPreco());
		cliente_ofertaAntigo.setDescricao(cliente_oferta.getDescricao());
		cliente_ofertaAntigo.setStatus(cliente_oferta.getStatus());
		cliente_ofertaAntigo.setFunilEtapa(cliente_oferta.getFunilEtapa());
		cliente_ofertaAntigo.setCliente(cliente_oferta.getCliente());
		/* cliente_ofertaAntigo.setOferta(cliente_oferta.getOferta()); */
		return save(cliente_ofertaAntigo);
	}
	
	public void delete(Integer id) {
		clienteOrepository.deleteById(id);
	}
	

}
