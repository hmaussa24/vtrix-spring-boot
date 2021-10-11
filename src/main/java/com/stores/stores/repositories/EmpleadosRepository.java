package com.stores.stores.repositories;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stores.stores.models.EmpleadosModel;

@Repository
public interface EmpleadosRepository extends CrudRepository<EmpleadosModel, Long> {
	public abstract ArrayList<EmpleadosModel> findByTiendaId(Long id);
	public abstract Optional<EmpleadosModel> findByEmail(String email);
}
