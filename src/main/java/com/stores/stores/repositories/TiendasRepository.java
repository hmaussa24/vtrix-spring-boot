package com.stores.stores.repositories;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stores.stores.models.TiendaModel;
import com.stores.stores.models.UsuarioModel;

@Repository
public interface TiendasRepository extends CrudRepository<TiendaModel, Long>{

	public abstract ArrayList<TiendaModel> findByUsuarioId(Long id);
}
