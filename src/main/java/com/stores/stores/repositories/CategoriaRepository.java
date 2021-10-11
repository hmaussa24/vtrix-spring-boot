package com.stores.stores.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stores.stores.models.CategoriaModel;

@Repository
public interface CategoriaRepository extends CrudRepository<CategoriaModel, Long>{

}
