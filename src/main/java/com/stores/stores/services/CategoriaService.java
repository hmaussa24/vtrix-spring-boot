package com.stores.stores.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stores.stores.models.CategoriaModel;
import com.stores.stores.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Iterable<CategoriaModel> categoriasAll() {
		return categoriaRepository.findAll();
	}
}
