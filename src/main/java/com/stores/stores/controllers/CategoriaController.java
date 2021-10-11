package com.stores.stores.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stores.stores.models.CategoriaModel;
import com.stores.stores.services.CategoriaService;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService service;
	
	@GetMapping(path = "/listar")
	public Iterable<CategoriaModel> listarCategorias(){
		return service.categoriasAll();
	}
}
