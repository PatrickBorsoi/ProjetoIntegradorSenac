package br.com.senac.repository;

import br.com.senac.domain.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepoository extends JpaRepository<Login, Integer> {
    Login findByLoginAndSenha(String login, String senha);
}
