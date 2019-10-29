package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.domain.Cliente;
import br.com.senac.repository.ClienteRepositorio;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepositorio repoCliente;
	
	public Cliente buscar(Integer id) throws ObjectNotFoundException{
		Optional<Cliente> objCliente = repoCliente.findById(id);
		return objCliente.orElseThrow(() -> new ObjectNotFoundException(
				" Não encotrado! id: " + id + ", Tipo!" + Cliente.class.getName()));
	}
	
	public Cliente alterar(Cliente objCliente) throws ObjectNotFoundException{
		Cliente objClienteEncontrado = buscar(objCliente.getCliente_id());
		objClienteEncontrado = buscar(objCliente.getCliente_id());
		objClienteEncontrado.setCliente_nome(objCliente.getCliente_nome());
		objClienteEncontrado.setCliente_sobrenome(objCliente.getCliente_sobrenome());
		objClienteEncontrado.setCliente_cpf(objCliente.getCliente_cpf());
		objClienteEncontrado.setCliente_email(objCliente.getCliente_email());
		objClienteEncontrado.setCliente_status(objCliente.getCliente_status());
		
		return repoCliente.save(objClienteEncontrado);
		
	}
	
	public List<Cliente> searchAll(){
		return repoCliente.findAll();
	}
	
	public Cliente inserir(Cliente Cliente){
		Cliente.setCliente_id(null);
		return repoCliente.save(Cliente);
	}
	
	public void excluir(Integer id) {
		repoCliente.deleteById(id);
		
	}
	
	public List<Cliente> listarCliente(){
		return repoCliente.findAll();
	}

}
