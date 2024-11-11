package com.mx.EmailUserApp.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mx.EmailUserApp.gen.Usuario;
import com.mx.EmailUserApp.model.UsuarioModel;

@Component
public class UsuarioConverter {
	
	public UsuarioModel convertUsuarioToUsuarioModel(Usuario usuario) {
		UsuarioModel usuarioModel= new UsuarioModel();
		usuarioModel.setId(usuario.getId());
		usuarioModel.setNombre(usuario.getNombre());
		usuarioModel.setEdad(usuario.getEdad());
		usuarioModel.setCorreo(usuario.getEmail());
		return usuarioModel;
	}
	
	public Usuario convertUsuarioModelToUsuario(UsuarioModel usuarioModel) {
		Usuario usuario= new Usuario();
		usuario.setId(usuarioModel.getId());
		usuario.setNombre(usuarioModel.getNombre());
		usuario.setEdad(usuarioModel.getEdad());
		usuario.setEmail(usuarioModel.getCorreo());
		return usuario;
	}
	
	public List<UsuarioModel> convertUsuariosToUsuariosModel(List<Usuario> liUsuario) {
		List<UsuarioModel> liUsuariosModel = new ArrayList<UsuarioModel>();
		for (Usuario valUsuario : liUsuario) {
			liUsuariosModel.add(convertUsuarioToUsuarioModel(valUsuario));
        }
		return liUsuariosModel;
	}
	
	public  List<Usuario> convertUsuarioModelToUsuario(List<UsuarioModel> liUsuariosModel) {
		List<Usuario> liUsuarios = new ArrayList<Usuario>();
		for (UsuarioModel valUsuario : liUsuariosModel) {
			liUsuarios.add(convertUsuarioModelToUsuario(valUsuario));
        }
		return liUsuarios;
	}

}
