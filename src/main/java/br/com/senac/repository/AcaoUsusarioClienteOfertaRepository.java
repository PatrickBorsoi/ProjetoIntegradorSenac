package br.com.senac.repository;

import br.com.senac.domain.AcaoUsuarioClienteOferta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcaoUsusarioClienteOfertaRepository extends JpaRepository<AcaoUsuarioClienteOferta, Integer> {
}
