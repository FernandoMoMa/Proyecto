package com.mx.EmailUserApp.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.mx.EmailUserApp.converter.UsuarioConverter;
import com.mx.EmailUserApp.gen.GetUsuariosResponse;
import com.mx.EmailUserApp.gen.PostUsuarioRequest;
import com.mx.EmailUserApp.gen.PostUsuarioResponse;
import com.mx.EmailUserApp.gen.Usuario;
import com.mx.EmailUserApp.model.UsuarioModel;
import com.mx.EmailUserApp.gen.GetUsuariosRequest;
import com.mx.EmailUserApp.repository.UsuarioRepository;

@Endpoint
public class UsuarioEndPoint {
	
	private static final String NAMESPACE_URI = "http://localhost:8080/EmailUserApp/gen";

	@Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private UsuarioConverter usuarioConverter;
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUsuariosRequest")
    @ResponsePayload
    public GetUsuariosResponse getUsuarios(@RequestPayload GetUsuariosRequest request){
    	GetUsuariosResponse poGetUsuariosResponse= new GetUsuariosResponse();
    	List<UsuarioModel> liUsuarioModel=usuarioRepository.findAll();
    	List<Usuario> liUsuario=usuarioConverter.convertUsuarioModelToUsuario(liUsuarioModel);
    	poGetUsuariosResponse.getUsuario().addAll(liUsuario);
    	return poGetUsuariosResponse;
    }
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postUsuarioRequest")
    @ResponsePayload
    public PostUsuarioResponse guardarUsuario(@RequestPayload PostUsuarioRequest request) {
    	PostUsuarioResponse poPostUsuarioResponse= new PostUsuarioResponse();
    	UsuarioModel poUsuarioModel= usuarioConverter.convertUsuarioToUsuarioModel(request.getUsuario());
    	Usuario poUsuario= usuarioConverter.convertUsuarioModelToUsuario(usuarioRepository.save(poUsuarioModel));
    	poPostUsuarioResponse.setUsuario(poUsuario);
    	poPostUsuarioResponse.setMensaje("Registro guardado");
    	return poPostUsuarioResponse;
    }
}
