package br.com.senac.domain;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Role implements GrantedAuthority {
    @Id
    private String userRole;

    @ManyToMany(mappedBy = "roles")
    private List<Usuario> usuarios;

    public String getUserRole(){
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;

    }
    @Override
    public String getAuthority(){
        return this.userRole;
    }
}
