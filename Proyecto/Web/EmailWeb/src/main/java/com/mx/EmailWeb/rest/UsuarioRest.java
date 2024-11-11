package com.mx.EmailWeb.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mx.EmailWeb.model.Usuario;
import com.mx.EmailWeb.util.Constantes;
@Service
public class UsuarioRest {
	
	private final RestTemplate restTemplate;
	
	public UsuarioRest (RestTemplate restTemplate){
		this.restTemplate =restTemplate;
	}
	
	public List<Usuario> obtenerUsuarios(){
		
		  // Configurar la cabecera con el token JWT
        HttpHeaders headers = new HttpHeaders();

        // Crear la solicitud
        HttpEntity<String> entity = new HttpEntity<>(headers);

        // Hacer la solicitud GET
        ResponseEntity<Usuario[]> response = restTemplate.exchange(
        	Constantes.URL_GET_USUARIOS,
            HttpMethod.GET,
            entity,
            Usuario[].class
        );

        // Convertir el array en una lista y devolverla
        return Arrays.asList(response.getBody());
	}
	
	public Usuario getGuardarUsuario(Usuario usuario) {

        // Configurar la cabecera con el token JWT
        HttpHeaders headers = new HttpHeaders();

        // Crear la solicitud
        HttpEntity<Usuario> entity = new HttpEntity<>(usuario,headers);

        // Hacer la solicitud POST
        ResponseEntity<Usuario> response = restTemplate.exchange(
        		Constantes.URL_SAVE_USUARIOS,
            HttpMethod.POST,
            entity,
            Usuario.class
        );

        // Convertir el array en una lista y devolverla
        return response.getBody();
    }

}
