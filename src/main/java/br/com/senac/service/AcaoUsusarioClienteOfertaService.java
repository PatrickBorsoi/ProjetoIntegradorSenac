package br.com.senac.service;

import br.com.senac.domain.AcaoUsuarioCliente;
import br.com.senac.domain.AcaoUsuarioClienteOferta;
import br.com.senac.repository.AcaoUsusarioClienteOfertaRepository;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AcaoUsusarioClienteOfertaService {

    @Autowired
    AcaoUsusarioClienteOfertaRepository acaoUsusarioClienteOfertaRepository;

    public AcaoUsuarioCliente ProcuraPorId(Integer id) throws ObjectNotFoundException {
        Optional<AcaoUsuarioClienteOferta> acaoUsusarioClienteOferta = acaoUsusarioClienteOfertaRepository.findById(id);

        return AcaoUsuarioCliente.orElseThrow(() -> new ObjectNotFoundException("AcaoUsusarioClienteOferta não encontrado. id:" + id));
    }

    public List<AcaoUsuarioClienteOferta> searchAll(){
        return acaoUsusarioClienteOfertaRepository.findAll();
    }

    public AcaoUsuarioClienteOferta salvar(AcaoUsuarioClienteOferta acaoUsuarioClienteOferta) {
        return acaoUsusarioClienteOfertaRepository.save(acaoUsuarioClienteOferta);
    }

    public AcaoUsuarioClienteOferta editar (AcaoUsuarioClienteOferta acaoUsuarioClienteOferta) throws ObjectNotFoundException {
        AcaoUsuarioCliente acaoUsuarioClienteOfertaAntigo = ProcuraPorId(acaoUsuarioClienteOferta.getId());
        acaoUsuarioClienteOfertaAntigo.setDescricao(acaoUsuarioClienteOferta.getDescricao());
        acaoUsuarioClienteOfertaAntigo.setData(acaoUsuarioClienteOferta.getData());
        acaoUsuarioClienteOfertaAntigo.setAcao(acaoUsuarioClienteOferta.getAcao());
        return salvar(acaoUsuarioClienteOfertaAntigo);
    }

    public void delete(Integer id) {
        acaoUsusarioClienteOfertaRepository.deleteById(id);

    }

}
