package com.stores.stores.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stores.stores.dto.ReporteMes;
import com.stores.stores.models.InventarioModel;
import com.stores.stores.repositories.InventarioRespository;

@Service
public class InventarioService {
	
	@Autowired
	InventarioRespository inventarioRepository;
	
	public InventarioModel guardarInventario(InventarioModel inventario) {
		return inventarioRepository.save(inventario);
	}
	
	public Iterable<InventarioModel> guardarInventarioAll(ArrayList<InventarioModel> inventario) {
		return inventarioRepository.saveAll(inventario);
	}
	
	public InventarioModel buscarByProductoId(Long id) {
		return inventarioRepository.findByProductoId(id);
	}
	
	public ArrayList<ReporteMes> reporteByMes(String anio, Long tienda){
		return inventarioRepository.reporteInventariMes(anio, tienda);
	}
	
	public ArrayList<ReporteMes> reporteByMesCredito(String anio, Long tienda){
		return inventarioRepository.reporteVentasMesCredito(anio, tienda);
	}
	

}
