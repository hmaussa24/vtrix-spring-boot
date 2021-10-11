package com.stores.stores.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stores.stores.models.ImegesModel;
import com.stores.stores.models.utils.ResponseError;
import com.stores.stores.services.ImagenesService;

@RestController
@RequestMapping(path = "/api/images")
public class ImagesController {
	
	@Autowired
	ImagenesService imagenesService;
	
	@PostMapping(path = "/registrar")
	public ResponseEntity<?> guardarImagen(@RequestBody ImegesModel img){
		return ResponseEntity.status(HttpStatus.CREATED).body(imagenesService.guardarImagen(img));
	}
	
	@GetMapping(path = "/imagenesproducto/{id}")
	public ResponseEntity<?> buscarByProdcuto(@PathVariable("id") Long id){
		ArrayList<ImegesModel> images = imagenesService.buscarPorProducto(id);
		if(!images.isEmpty()) {
			return ResponseEntity.ok(images);
		}
		
		return ResponseEntity.ok(new ResponseError("Sin imagenes", 205));
	}

}
