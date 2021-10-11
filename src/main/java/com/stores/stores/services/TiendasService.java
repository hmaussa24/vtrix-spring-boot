package com.stores.stores.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stores.stores.models.TiendaModel;
import com.stores.stores.repositories.TiendasRepository;

@Service
public class TiendasService {
	
	@Autowired
	TiendasRepository tiendaRepository;
	
	
	public TiendaModel guardarTienda(TiendaModel tienda) {
		return tiendaRepository.save(tienda);
	}
	
	
	public Optional<TiendaModel> buscarById(Long id){
		return tiendaRepository.findById(id);
	}
	
	public ArrayList<TiendaModel> buscarByUser(Long id){
		return tiendaRepository.findByUsuarioId(id);
	}

}
