package com.stores.stores.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stores.stores.models.UsuarioModel;
import com.stores.stores.services.UsuarioService;

@RestController
@RequestMapping("api/register")
@CrossOrigin("*")
public class RegisterController {

	@Autowired
	UsuarioService usuarioService;
	
	
	@PostMapping()
	public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario) {
		return usuarioService.guardarUsuario(usuario);
	}
}
