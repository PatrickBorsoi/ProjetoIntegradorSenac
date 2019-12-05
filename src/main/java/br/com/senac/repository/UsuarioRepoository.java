package br.com.senac.repository;

import br.com.senac.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepoository extends CrudRepository<Usuario, String> {
    Usuario findByLogin(String login);
}
