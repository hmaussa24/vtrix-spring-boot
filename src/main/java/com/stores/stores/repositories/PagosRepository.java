package com.stores.stores.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stores.stores.models.PagosModel;

@Repository
public interface PagosRepository extends CrudRepository<PagosModel, Long> {
	
	public abstract ArrayList<PagosModel> findByCreditoId(Long credito);

}
