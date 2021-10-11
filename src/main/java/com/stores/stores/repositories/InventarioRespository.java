package com.stores.stores.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stores.stores.models.InventarioModel;

@Repository
public interface InventarioRespository extends CrudRepository<InventarioModel, Long> {
	
	public abstract InventarioModel findByProductoId(Long id);

}
