package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.domain.Funil_etapa;

@Repository
public interface Funil_etapaRepository extends JpaRepository<Funil_etapa, Integer> {

}
