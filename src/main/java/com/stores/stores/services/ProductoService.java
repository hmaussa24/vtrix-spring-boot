package com.stores.stores.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.stores.stores.models.ProductoModel;
import com.stores.stores.repositories.ProductoRepository;

@Service
public class ProductoService {
	
	@Autowired
	ProductoRepository productoRepository;
	
	public ProductoModel guardarProducto(ProductoModel producto) {
		return productoRepository.save(producto);
	}
	
	public Optional<ProductoModel> buacarById(Long id) {
		return productoRepository.findById(id);
	}
	
	public ArrayList<ProductoModel> buscarByNombre(String nombre, Long id) {
		return productoRepository.findByNombreAndTienda(nombre, id);
	}
	
	public Optional<ProductoModel> buscarByCategoria(Long cat, Long id) {
		return productoRepository.findByCategoriaAndTienda(cat, id);
	}
	

	public Optional<ProductoModel> buscarByCodigo(String codigo, Long id) {
		return productoRepository.findByCodigo(codigo, id);
	}
	
	public Optional<ProductoModel> buscarByDescripcion(String des, Long id) {
		return productoRepository.findByDescripcionAndTienda(des, id);
	}
	
	public ArrayList<ProductoModel> buscarByTienda(Long id) {
		return productoRepository.findByTiendaId(id);
	}

}
