package com.store.store.dto;

import java.util.ArrayList;

import com.stores.stores.models.DetalleVentaModel;
import com.stores.stores.models.VentaModel;

public class VentasDiariasDTO {

	private VentaModel venta;
	private ArrayList<DetalleVentaModel> detalles;

	public VentaModel getVenta() {
		return venta;
	}

	public void setVenta(VentaModel venta) {
		this.venta = venta;
	}

	public ArrayList<DetalleVentaModel> getDetalles() {
		return detalles;
	}

	public void setDetalles(ArrayList<DetalleVentaModel> detalles) {
		this.detalles = detalles;
	}

}
