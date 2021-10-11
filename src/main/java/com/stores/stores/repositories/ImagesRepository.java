package com.stores.stores.repositories;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stores.stores.models.ImegesModel;

@Repository
public interface ImagesRepository extends CrudRepository<ImegesModel, Long> {

	public ArrayList<ImegesModel> findByProductoId(Long producto);
}
