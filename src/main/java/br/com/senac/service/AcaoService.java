package br.com.senac.service;

import br.com.senac.domain.Acao;
import br.com.senac.repository.AcaoRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AcaoService {
    @Autowired
    AcaoRepository acaorepository;

    public Acao ProcurarPorId(Integer id) throws ObjectNotFoundException {
        Optional<Acao> Acao = acaorepository.findById(id);

        return Acao.orElseThrow(() -> new ObjectNotFoundException(
                "não encontrado. id: " + id + ", Tipo!", null));
    }

    public List<Acao> ProcurarTodasAcoes(){
        return acaorepository.findAll();
    }

    public Acao salvar(Acao Acao) {
        return acaorepository.save(Acao);
    }

    public List<Acao> salvarTodos(List<Acao> nivelInstrucoes) {
        return acaorepository.saveAll(nivelInstrucoes);
    }

    public Acao editar (Acao Acao) throws ObjectNotFoundException {
        Acao AcaoAntigo = ProcurarPorId(Acao.getId());
        AcaoAntigo.setDescricao(Acao.getDescricao());
        AcaoAntigo.setStatus(Acao.getStatus());

        return salvar(AcaoAntigo);
    }

    public void delete(Integer id) {
        acaorepository.deleteById(id);

    }
    
}
