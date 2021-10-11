package com.stores.stores.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stores.stores.models.ImegesModel;
import com.stores.stores.repositories.ImagesRepository;

@Service
public class ImagenesService {

	@Autowired
	ImagesRepository imagesRepository;
	
	public ImegesModel guardarImagen(ImegesModel img) {
		return imagesRepository.save(img);
	}
	
	public ArrayList<ImegesModel> buscarPorProducto(Long id){
		return imagesRepository.findByProductoId(id);
	}
}
