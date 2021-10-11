package com.stores.stores.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stores.stores.models.ClienteModel;

@Repository
public interface ClienteRepository extends CrudRepository<ClienteModel, Long> {

	public Optional<ClienteModel> findByCedula(String cedula);
}
