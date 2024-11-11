package com.mx.EmailUserApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.EmailUserApp.model.UsuarioModel;
import java.util.List;


public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long>{
	
	UsuarioModel findByNombre(String nombre);

}
