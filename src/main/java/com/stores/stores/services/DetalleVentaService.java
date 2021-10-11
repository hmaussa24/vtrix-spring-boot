package com.stores.stores.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stores.stores.models.DetalleVentaModel;
import com.stores.stores.models.VentaModel;
import com.stores.stores.repositories.DetalleVentaRepository;

@Service
public class DetalleVentaService {

	@Autowired
	DetalleVentaRepository detalleVentaRepository;
	
	public Iterable<DetalleVentaModel> guardarDetalle(Iterable<DetalleVentaModel> detalle){
		return detalleVentaRepository.saveAll(detalle);
	}
	
	public ArrayList<DetalleVentaModel> buscarByVenta(VentaModel venta){
		return detalleVentaRepository.findByVenta(venta);
	}
}
