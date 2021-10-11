package com.stores.stores.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stores.stores.models.ClienteModel;
import com.stores.stores.models.utils.ResponseError;
import com.stores.stores.services.ClienteService;

@RestController
@RequestMapping(path = "/api/clientes")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	

	@GetMapping(path = "/{cedula}")
	public ResponseEntity<?> buscarByCedula(@PathVariable("cedula") String cedula){
		Optional<ClienteModel> cliente = clienteService.buscraByCedula(cedula);
		if(cliente.isPresent()) {
			return ResponseEntity.ok(cliente);
		}
		
		return ResponseEntity.ok(new  ResponseError("Usuario no encontrado", 205));
	}
	
	@PostMapping(path = "/registrar")
	public ResponseEntity<?> guardarCliente(@RequestBody ClienteModel cliente){
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.guardarCliente(cliente));
	}

}
