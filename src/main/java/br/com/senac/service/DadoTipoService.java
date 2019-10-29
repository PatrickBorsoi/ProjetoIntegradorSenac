package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.domain.DadoTipo;
import br.com.senac.repository.DadoTipoRepositorio;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class DadoTipoService {
	
	@Autowired
	private DadoTipoRepositorio repoDadoTipo;
	
	public DadoTipo buscar(Integer id) throws ObjectNotFoundException{
		Optional<DadoTipo> objDadoTipo = repoDadoTipo.findById(id);
		return objDadoTipo.orElseThrow(() -> new ObjectNotFoundException(
				" Não encontrado! id: " + id + ", Tipo!" + DadoTipo.class.getName())); 
	}
	
	public DadoTipo alterar(DadoTipo objDadoTipo) throws ObjectNotFoundException{
		DadoTipo objDadoTipoEncontrado = buscar(objDadoTipo.getDado_tipo_id());
		objDadoTipoEncontrado = buscar(objDadoTipo.getDado_tipo_id());
		objDadoTipoEncontrado.setDado_tipo_descricao(objDadoTipo.getDado_tipo_descricao());
		objDadoTipoEncontrado.setCategoriadado(objDadoTipo.getCategoriadado());
		objDadoTipoEncontrado.setDado_tipo_mascara(objDadoTipo.getDado_tipo_mascara());
		objDadoTipoEncontrado.setDado_tipo_status(objDadoTipo.getDado_tipo_status());
		objDadoTipoEncontrado.setDado_tipo_padrao(objDadoTipo.getDado_tipo_padrao());
		objDadoTipoEncontrado.setDado_tipo_obrigatorio(objDadoTipo.getDado_tipo_obrigatorio());
		
		return repoDadoTipo.save(objDadoTipoEncontrado);		
	}
	
	public DadoTipo inserir(DadoTipo dadotipo) {
		dadotipo.setDado_tipo_id(null);;
		return repoDadoTipo.save(dadotipo);
	}
	
	public void excluir(Integer id) {
		repoDadoTipo.deleteById(id);
	}
	
	public List<DadoTipo> listarDadoTipo(){
		return repoDadoTipo.findAll();
	}

}
