package com.stores.stores.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stores.stores.dto.VentasDiariasDTO;
import com.stores.stores.models.DetalleVentaModel;
import com.stores.stores.models.InventarioModel;
import com.stores.stores.models.VentaModel;
import com.stores.stores.models.utils.VentaRequest;
import com.stores.stores.services.DetalleVentaService;
import com.stores.stores.services.InventarioService;
import com.stores.stores.services.VentaService;

@RestController
@RequestMapping(path = "/api/ventas")
public class VentaController {

	@Autowired
	DetalleVentaService detalleVentaService;

	@Autowired
	VentaService ventaService;

	@Autowired
	InventarioService inventarioService;

	@PostMapping(path = "/registrar")
	public ResponseEntity<?> guardarVena(@RequestBody VentaRequest venta) {
		if (venta.getCredito().getNumcuotas() != null) {
			venta.getVenta().setTipo(1);
		}
		VentaModel ventatemp = ventaService.guardarVenta(venta.getVenta());
		ArrayList<InventarioModel> inventario = new ArrayList<InventarioModel>();
		if (venta.getCredito().getNumcuotas() != null) {
			venta.getCredito().setVenta(ventatemp);
			ventaService.guardarCredito(venta.getCredito());
		}
		for (DetalleVentaModel det : venta.getDetalle()) {
			det.setVenta(ventatemp);
			InventarioModel inv = inventarioService.buscarByProductoId(det.getProducto().getId());
			inv.setStock(inv.getStock() - det.getCantidad());
			inventario.add(inv);
		}

		inventarioService.guardarInventarioAll(inventario);
		detalleVentaService.guardarDetalle(venta.getDetalle());
		return ResponseEntity.ok(ventatemp);

	}
	
	@GetMapping(path = "/informediario/{fecha}")
	public ResponseEntity<?> informeDiario(@PathVariable("fecha") String fecha){

		ArrayList<VentaModel> ventas = ventaService.buscarByFecha(fecha);
		ArrayList<VentasDiariasDTO> diarias = new  ArrayList<VentasDiariasDTO>();
		for(VentaModel venta: ventas) {
			System.out.print(venta.getFecha());
			VentasDiariasDTO diaria = new VentasDiariasDTO();
			diaria.setVenta(venta);
			diaria.setDetalles(detalleVentaService.buscarByVenta(venta));
			diarias.add(diaria); 
		}
		
		return ResponseEntity.ok(diarias);
	}

}
