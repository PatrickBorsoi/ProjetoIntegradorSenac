package br.com.senac.service;


import br.com.senac.domain.AcaoUsuarioCliente;
import br.com.senac.repository.AcaoUsusarioClienteRepository;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AcaoUsuarioClienteService {
    @Autowired
    AcaoUsusarioClienteRepository acaoUsusarioClienteRepository;

    public AcaoUsuarioCliente ProcuraPorId(Integer id) throws ObjectNotFoundException {
        Optional<AcaoUsuarioCliente> acaoUsuarioCliente = acaoUsusarioClienteRepository.findById(id);

        return AcaoUsuarioCliente.orElseThrow(() -> new ObjectNotFoundException("acaoUsusarioCliente não encontrado. id:" + id));
    }

    public List<AcaoUsuarioCliente> searchAll(){
        return acaoUsusarioClienteRepository.findAll();
    }

    public AcaoUsuarioCliente save(AcaoUsuarioCliente AcaoUsuarioCliente) {
        return acaoUsusarioClienteRepository.save(AcaoUsuarioCliente);
    }

    public List<AcaoUsuarioCliente> saveAll(List<AcaoUsuarioCliente> nivelInstrucoes) {
        return acaoUsusarioClienteRepository.saveAll(nivelInstrucoes);
    }

    public AcaoUsuarioCliente edit (AcaoUsuarioCliente AcaoUsuarioCliente) throws ObjectNotFoundException {
        AcaoUsuarioCliente AcaoUsuarioClienteAntigo = ProcuraPorId(AcaoUsuarioCliente.getId());
        AcaoUsuarioClienteAntigo.setDescricao(AcaoUsuarioCliente.getDescricao());
        AcaoUsuarioClienteAntigo.setAcao(AcaoUsuarioCliente.getAcao());
        return save(AcaoUsuarioClienteAntigo);
    }

    public void delete(Integer id) {
        acaoUsusarioClienteRepository.deleteById(id);

    }

}
