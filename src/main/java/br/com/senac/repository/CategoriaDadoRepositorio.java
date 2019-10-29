package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.domain.CategoriaDado;


@Repository
public interface CategoriaDadoRepositorio extends JpaRepository<CategoriaDado, Integer>{

}
