package com.mx.EmailApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.EmailApp.model.Usuario;
import com.mx.EmailApp.service.UsuarioService;

@RestController
@RequestMapping("/rest/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/")
	public String inicioServicio() {
	return 	"Inicia servicios de EmailApp";
	}
	
	@GetMapping("/getUsuarios")
	public List<Usuario> obtenerUsuarios() {
	return 	usuarioService.getUsuarios();
	}
	
	@PostMapping("/guardarUsuarios")
	public Usuario guardarUsuarios(@RequestBody Usuario usuario) {
	return 	usuarioService.saveUser(usuario);
	}
}
