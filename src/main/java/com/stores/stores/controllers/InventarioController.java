package com.stores.stores.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stores.stores.models.InventarioModel;
import com.stores.stores.services.InventarioService;

@RestController
@RequestMapping("/api/inventario")
public class InventarioController {

	@Autowired
	InventarioService inventarioService;
	
	
	@GetMapping(path = "/{producto}")
	public InventarioModel buscarByProducto(@PathVariable("producto") Long id) {
		return inventarioService.buscarByProductoId(id);
	}
	
	@PostMapping(path = "/guardar")
	public InventarioModel guardarInventario(@RequestBody InventarioModel inventario) {
		return inventarioService.guardarInventario(inventario);
		//return inventario;
	}
}