package com.mx.EmailWeb.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mx.EmailWeb.model.Usuario;
import com.mx.EmailWeb.rest.UsuarioRest;
import com.mx.EmailWeb.util.Constantes;

@Controller
public class UsuarioWebController {
	
	
	 // Lista de palabras reservadas
   List<String> reservedWords = Arrays.asList("SELECT", "INSERT", "UPDATE", "DELETE", "DROP", "&&&%", "OR", "AND", "--", "/*", "*/");
   private final UsuarioRest usuarioRest;
   
   public UsuarioWebController(UsuarioRest usuarioRest){
	   this.usuarioRest=usuarioRest;
   }
	
	 @GetMapping({"/","/index"})
	    public String mostrarLista(Model model) {
		 try {
	    	List<Usuario> liUsuario=usuarioRest.obtenerUsuarios();
	    	model.addAttribute("liUsuario",liUsuario);
	        return "index";
		 }catch(Exception ex) {
			 ex.printStackTrace();
			 return "404";
		 }
	    }
	 
	 @PostMapping("/guardarUsuario")
	 @ResponseBody
	 public String procesarUsuario(@RequestBody Usuario usuario ) {
		 try {
			 System.out.println("Usuario "+usuario.getCorreo());
			 if(usuario.getNombre()!=null && usuario.getCorreo()!=null && usuario.getEdad()!=null) {
				 
				 if(usuario.getNombre().length()>0 && usuario.getCorreo().length()>0) {
					 
					 if(usuario.getNombre().length()<=50) {
						// Validar formato del correo
			                String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
			                if (!usuario.getCorreo().matches(emailRegex)) {
			                    return "El formato del correo no es válido";
			                }else {
			                	Usuario guardoElUsuario= usuarioRest.getGuardarUsuario(usuario);
								 return "OK";
			                }
						 
					 }else {
						 return "El nombre del usuario no debe ser mayor a 50 caracteres";
					 }
				 }else {
					 return "Todos los registros son requeridos";
				 }
			 }else {
				 return "Todos los registros son requeridos";
			 }
		
		 }catch(Exception ex) {
			 ex.printStackTrace();
			 return "Ocurrio un problema";
		 }
	 }

}
