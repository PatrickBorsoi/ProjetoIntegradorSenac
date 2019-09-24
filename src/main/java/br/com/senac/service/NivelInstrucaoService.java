package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.domain.NivelInstrucao;
import br.com.senac.repository.NivelInstrucaoRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class NivelInstrucaoService {
	@Autowired
	NivelInstrucaoRepository nivelrepository;

	public NivelInstrucao search(Integer id) throws ObjectNotFoundException{
		Optional<NivelInstrucao> nivelInstrucao = nivelrepository.findById(id);
		
		return nivelInstrucao.orElseThrow(() -> new ObjectNotFoundException(
				"não encontrado. id: " + id + ", Tipo!" + NivelInstrucao.class.getName()));
	}
	
	public List<NivelInstrucao> searchAll(){
		return nivelrepository.findAll();
	}
	
	public NivelInstrucao save(NivelInstrucao nivelInstrucao) {
		return nivelrepository.save(nivelInstrucao);
	}
	
	public List<NivelInstrucao> saveAll(List<NivelInstrucao> nivelInstrucoes) {
		return nivelrepository.saveAll(nivelInstrucoes);
	}
	
	public NivelInstrucao edit (NivelInstrucao nivelInstrucao) throws ObjectNotFoundException {
		NivelInstrucao nivelInstrucaoAntigo = search(nivelInstrucao.getId());
		nivelInstrucaoAntigo.setDescricao(nivelInstrucao.getDescricao());
		nivelInstrucaoAntigo.setStatus(nivelInstrucao.getStatus());
		
		return save(nivelInstrucaoAntigo);
	}
	
	public void delete(Integer id) {
		nivelrepository.deleteById(id);
		
	}
	
	
}
