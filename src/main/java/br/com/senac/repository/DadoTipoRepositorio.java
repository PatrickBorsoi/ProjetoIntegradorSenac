package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.domain.DadoTipo;


@Repository
public interface DadoTipoRepositorio extends JpaRepository<DadoTipo, Integer>{

}
