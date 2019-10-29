package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.domain.CategoriaDado;
import br.com.senac.repository.CategoriaDadoRepositorio;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CategoriaDadoService {
	
	@Autowired
	private CategoriaDadoRepositorio repoCategoriaDado;
	
	public CategoriaDado buscar(Integer id) throws ObjectNotFoundException{
		Optional<CategoriaDado> objCategoriaDado = repoCategoriaDado.findById(id);
		return objCategoriaDado.orElseThrow(() -> new ObjectNotFoundException(
				" Não encotrado! id: " + id + ", Tipo!" + CategoriaDado.class.getName()));
	}
	
	public CategoriaDado alterar(CategoriaDado objCategoriaDado) throws ObjectNotFoundException{
		CategoriaDado objCategoriaDadoEncontrado = buscar(objCategoriaDado.getCategoria_dado_id());
		objCategoriaDadoEncontrado = buscar(objCategoriaDado.getCategoria_dado_id());
		objCategoriaDadoEncontrado.setCategoria_dado_descricao(objCategoriaDado.getCategoria_dado_descricao());
		objCategoriaDadoEncontrado.setCategoria_dado_status(objCategoriaDado.getCategoria_dado_status());
		
		return repoCategoriaDado.save(objCategoriaDadoEncontrado);
		
	}
	
	public CategoriaDado inserir(CategoriaDado CategoriaDado){
		CategoriaDado.setCategoria_dado_id(null);
		return repoCategoriaDado.save(CategoriaDado);
	}
	
	public void excluir(Integer id) {
		repoCategoriaDado.deleteById(id);
		
	}
	
	public List<CategoriaDado> listarCategoriaDado(){
		return repoCategoriaDado.findAll();
	}

}
