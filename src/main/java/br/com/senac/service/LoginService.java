package br.com.senac.service;

import br.com.senac.domain.Login;
import br.com.senac.repository.LoginRepoository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private LoginRepoository loginRepoository;

    public boolean login(Login login){
        Login loginEncontrado = loginRepoository.findByLoginAndSenha(login.getLogin(), login.getSenha());
        if(loginEncontrado == null){
            return false;
        }
        return true;
    }
}
