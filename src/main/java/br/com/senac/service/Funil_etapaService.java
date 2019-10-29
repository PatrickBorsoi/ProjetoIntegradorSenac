package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.domain.Funil_etapa;
import br.com.senac.repository.Funil_etapaRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class Funil_etapaService {
	@Autowired
	Funil_etapaRepository funilrepository;
	
	public Funil_etapa search(Integer id) throws ObjectNotFoundException{
		Optional<Funil_etapa>funil_etapa = funilrepository.findById(id);
		
		return funil_etapa.orElseThrow(() -> new ObjectNotFoundException(
				"não encontrado. id: " + id + ", Tipo!" + Funil_etapa.class.getName()));
	}
	
	public List<Funil_etapa> searchAll(){
		return funilrepository.findAll();
	}
	
	public Funil_etapa save(Funil_etapa funil_etapa) {
		return funilrepository.save(funil_etapa);
	}
	
	public List<Funil_etapa> saveAll(List<Funil_etapa> funil_etapas) {
		return funilrepository.saveAll(funil_etapas);
	}
	
	public Funil_etapa edit (Funil_etapa funil_etapa) throws ObjectNotFoundException {
		Funil_etapa funil_etapaAntigo = search(funil_etapa.getId());
		funil_etapaAntigo.setDescricao(funil_etapa.getDescricao());
		funil_etapaAntigo.setStatus(funil_etapa.getStatus());
		
		return save(funil_etapaAntigo);
	}
	
	public void delete(Integer id) {
		funilrepository.deleteById(id);
		
	}
	

}
