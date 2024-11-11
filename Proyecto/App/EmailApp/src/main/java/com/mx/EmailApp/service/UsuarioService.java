package com.mx.EmailApp.service;

import java.util.List;
import com.mx.EmailApp.model.Usuario;

public interface UsuarioService {
	
	public List<Usuario> getUsuarios();
	
	public Usuario saveUser(Usuario usuario);

}
