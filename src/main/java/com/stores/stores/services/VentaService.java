package com.stores.stores.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stores.stores.models.CreditoModel;
import com.stores.stores.models.VentaModel;
import com.stores.stores.repositories.CreditoRepository;
import com.stores.stores.repositories.VentaRepository;

@Service
public class VentaService {

	@Autowired
	VentaRepository ventaRepository;

	@Autowired
	CreditoRepository creditoRepository;

	public VentaModel guardarVenta(VentaModel venta) {
		return ventaRepository.save(venta);
	}

	public CreditoModel guardarCredito(CreditoModel credito) {
		return creditoRepository.save(credito);
	}

	public ArrayList<VentaModel> buscarByFecha(String fecha, Long tienda) {
		return ventaRepository.ventasByFechaVenta(fecha, tienda);
	}
}
