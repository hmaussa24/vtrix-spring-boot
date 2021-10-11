package com.stores.stores.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stores.stores.models.PagosModel;
import com.stores.stores.services.PagosService;

@RestController
@RequestMapping(path = "/api/pagos")
public class PagosController {
	
	@Autowired
	PagosService pagosService;
	
	@PostMapping(path = "/registrar")
	public ResponseEntity<?> guardarPago(@RequestBody PagosModel pago){
		return ResponseEntity.ok(pagosService.pagarCuota(pago));
	}
	
	
	@GetMapping(path = "/{credito}")
	public ResponseEntity<?> buscarByCredito(@PathVariable("credito") Long id){
		return ResponseEntity.ok(pagosService.buacarByCredito(id));
	}
	

}
