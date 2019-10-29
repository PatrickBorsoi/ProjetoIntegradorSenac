package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.domain.Cliente_oferta;

@Repository
public interface Cliente_ofertaRepository extends JpaRepository<Cliente_oferta, Integer> {

}
