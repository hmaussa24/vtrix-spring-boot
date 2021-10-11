package com.stores.stores.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stores.stores.models.EmpleadosModel;
import com.stores.stores.models.TiendaModel;
import com.stores.stores.repositories.EmpleadosRepository;

@Service
public class EmpleadosService {

	@Autowired
	EmpleadosRepository empleadoRepositopri;
	
	
	public EmpleadosModel guardarTienda(EmpleadosModel empleado) {
		return empleadoRepositopri.save(empleado);
	}
	
	public ArrayList<EmpleadosModel> empleadosByTienda(Long id){
		return empleadoRepositopri.findByTiendaId(id);
	}
	
	public Optional<EmpleadosModel> buscarByEmail(String email) {
		return empleadoRepositopri.findByEmail(email);
	}
	
}
