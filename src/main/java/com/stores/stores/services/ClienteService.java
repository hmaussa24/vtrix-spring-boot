package com.stores.stores.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.stores.stores.models.ClienteModel;
import com.stores.stores.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	public Optional<ClienteModel> buscraByCedula(String cliente){
		return clienteRepository.findByCedula(cliente);
	}
	
	public ClienteModel guardarCliente(ClienteModel cliente){
		return clienteRepository.save(cliente);
	}

}
