package com.stores.stores.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.stores.stores.models.CreditoModel;
import com.stores.stores.repositories.CreditoRepository;

@Service
public class CreditoService {
	
	@Autowired
	CreditoRepository creditoRepository;
	
	
	public CreditoModel guardarCredito(CreditoModel credito) {
		return creditoRepository.save(credito);
	}
	
	public Iterable<CreditoModel> allCreditos(Long id){
		return creditoRepository.findAll();
	}
	
	public ArrayList<CreditoModel> buscarByCedula(String cedula){
		return creditoRepository.buscarByCedula(cedula);
	}
	
	public Optional<CreditoModel> huscraById(Long id){
		return creditoRepository.findById(id);
	}
	
	public ArrayList<CreditoModel> buscarByTienda(Long id){
		return creditoRepository.findByTiendaId(id);
	}

}
