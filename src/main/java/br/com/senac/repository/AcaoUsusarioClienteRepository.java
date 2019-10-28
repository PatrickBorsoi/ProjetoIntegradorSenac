package br.com.senac.repository;

import br.com.senac.domain.AcaoUsuarioCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcaoUsusarioClienteRepository extends JpaRepository<AcaoUsuarioCliente, Integer> {
}
