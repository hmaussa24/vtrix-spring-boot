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

import com.stores.stores.models.CreditoModel;
import com.stores.stores.models.utils.ResponseError;
import com.stores.stores.services.CreditoService;

@RestController
@RequestMapping(path = "/api/creditos")
public class CreditoController {
	
	@Autowired
	CreditoService creditoService;
	
	@PostMapping(path = "/registro")
	public ResponseEntity<?> guardarCredito(@RequestBody CreditoModel credito){
		credito.setEstado(1);
		return ResponseEntity.status(HttpStatus.CREATED).body(creditoService.guardarCredito(credito));
	}
	
	@GetMapping(path = "/{tienda}")
	public ResponseEntity<?> allCreditos(@PathVariable("tienda") Long id){
		return ResponseEntity.ok(creditoService.buscarByTienda(id));
	}
	
	@GetMapping(path = "/cedula/{cedula}")
	public ResponseEntity<?> buscraByCedula(@PathVariable("cedula") String cedula){
		return ResponseEntity.ok(creditoService.buscarByCedula(cedula));
	}
	
	@GetMapping(path = "/credito/{id}")
	public ResponseEntity<?> buscarById(@PathVariable("id") Long id){
		Optional<CreditoModel> credito = creditoService.huscraById(id);
		if(credito.isPresent()) {
			return ResponseEntity.ok(credito);
		}
		return ResponseEntity.ok(new ResponseError("Nio se encontro credito", 205));
	}

}
