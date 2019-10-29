package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.domain.Cliente;


@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Integer>{

}
