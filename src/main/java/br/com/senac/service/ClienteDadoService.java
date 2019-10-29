package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.domain.ClienteDado;
import br.com.senac.repository.ClienteDadoRepositorio;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ClienteDadoService {
	
	@Autowired
	private ClienteDadoRepositorio repoClienteDado;
	
	public ClienteDado buscar(Integer id) throws ObjectNotFoundException{
		Optional<ClienteDado> objClienteDado = repoClienteDado.findById(id);
		return objClienteDado.orElseThrow(() -> new ObjectNotFoundException(
				" Não encotrado! id: " + id + ", Tipo!" + ClienteDado.class.getName()));
	}
	
	public ClienteDado alterar(ClienteDado objClienteDado) throws ObjectNotFoundException{
		ClienteDado objClienteDadoEncontrado = buscar(objClienteDado.getCliente_dado_id());
		objClienteDadoEncontrado = buscar(objClienteDado.getCliente_dado_id());
		objClienteDadoEncontrado.setCliente_dado_status(objClienteDado.getCliente_dado_status());
		objClienteDadoEncontrado.setCliente_dado_valor(objClienteDado.getCliente_dado_valor());
		objClienteDadoEncontrado.setCliente(objClienteDado.getCliente());
		objClienteDadoEncontrado.setDadotipo(objClienteDado.getDadotipo());
		
		return repoClienteDado.save(objClienteDadoEncontrado);
		
	}
	
	public ClienteDado inserir(ClienteDado ClienteDado){
		ClienteDado.setCliente_dado_id(null);;
		return repoClienteDado.save(ClienteDado);
	}
	
	public void excluir(Integer id) {
		repoClienteDado.deleteById(id);
		
	}
	
	public List<ClienteDado> listarClienteDado(){
		return repoClienteDado.findAll();
	}

}
