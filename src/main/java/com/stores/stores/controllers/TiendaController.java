package com.stores.stores.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stores.stores.models.TiendaModel;
import com.stores.stores.services.TiendasService;

@RestController
@RequestMapping("/api/tienda")
public class TiendaController {

	@Autowired
	TiendasService tiendaService;

	@PostMapping(path = "/registrar")
	public TiendaModel guardarTienda(@RequestBody TiendaModel tienda) {
        return tiendaService.guardarTienda(tienda);
	}
	
	
	@GetMapping(path = "/{id}")
	public Optional<TiendaModel> getTiendas(@PathVariable("id") Long id){
		return tiendaService.buscarById(id);
	}
	
	@GetMapping(path = "/mistiendas/{user}")
	public ArrayList<TiendaModel> getUserTiendas(@PathVariable("user") Long id){
		return tiendaService.buscarByUser(id);
	}
}
