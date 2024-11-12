package com.web.app.pronet.services; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.web.app.pronet.models.*;
import com.web.app.pronet.repo.UsuarioRepo;


@Service
public class UsuarioService {
 @Autowired
    private UsuarioRepo repository;
    
    public List<Usuario> GetAllUsers() {
        // TODO Auto-generated method stub
        return repository.findAll();
    }
    public Usuario createUser(Usuario user) {
        return repository.save(user);
    }
    public Usuario getUserById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Usuario updateUser(Long id, Usuario user) {
        user.setId(id);
        return repository.save(user);
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}