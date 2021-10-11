package com.stores.stores.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stores.stores.models.UsuarioModel;
import com.stores.stores.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	public ArrayList<UsuarioModel> listarUsuarios() {
		return (ArrayList<UsuarioModel>)usuarioRepository.findAll();
	}
	
	public UsuarioModel guardarUsuario(UsuarioModel user) {
		return usuarioRepository.save(user);
	}
	
	public Optional<UsuarioModel> userById(Long id){
		return usuarioRepository.findById(id);
	}
	
	public Optional<UsuarioModel> userByEmail(String email){
		return usuarioRepository.findByEmail(email);
	}
}
