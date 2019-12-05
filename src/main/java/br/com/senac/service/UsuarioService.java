package br.com.senac.service;

import br.com.senac.domain.Usuario;
import br.com.senac.repository.UsuarioRepoository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepoository usuarioRepoository;

    public boolean login(Usuario login){
        Usuario loginEncontrado = usuarioRepoository.findByLogin(login.getLogin());
        if(loginEncontrado == null){
            return false;
        }
        return true;
    }
}
