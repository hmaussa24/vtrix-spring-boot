package com.stores.stores.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stores.stores.models.PagosModel;
import com.stores.stores.repositories.PagosRepository;

@Service
public class PagosService {
	
	@Autowired
	PagosRepository pagosRepository;

	public PagosModel pagarCuota( PagosModel pago) {
		return pagosRepository.save(pago);
	}
	
	public ArrayList<PagosModel> buacarByCredito(Long id){
		return pagosRepository.findByCreditoId(id);
	}

}
