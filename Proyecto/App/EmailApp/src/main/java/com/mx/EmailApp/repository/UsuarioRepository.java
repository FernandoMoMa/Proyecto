package com.mx.EmailApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mx.EmailApp.model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	
}
