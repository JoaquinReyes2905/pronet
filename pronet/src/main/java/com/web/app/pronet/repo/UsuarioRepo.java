package com.web.app.pronet.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.app.pronet.models.Usuario;

public interface UsuarioRepo extends JpaRepository<Usuario,Long>{
	
}
