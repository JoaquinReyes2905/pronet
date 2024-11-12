package com.web.app.pronet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.web.app.pronet.repo.*;
import java.util.List;
import com.web.app.pronet.models.*;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepo repository;

    public List<Producto> GetAllUsers() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	public Producto createUser(Producto user) {
        return repository.save(user);
    }
	public Producto getUserById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Producto updateUser(Long id, Producto user) {
        user.setId(id);
        return repository.save(user);
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}
