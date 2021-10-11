package com.stores.stores.models.utils;

import java.util.ArrayList;

import com.stores.stores.models.CreditoModel;
import com.stores.stores.models.DetalleVentaModel;
import com.stores.stores.models.VentaModel;

public class VentaRequest {

	private VentaModel venta;
	private ArrayList<DetalleVentaModel> detalle;
	private CreditoModel credito;
	public CreditoModel getCredito() {
		return credito;
	}
	public void setCredito(CreditoModel credito) {
		this.credito = credito;
	}
	public VentaModel getVenta() {
		return venta;
	}
	public void setVenta(VentaModel venta) {
		this.venta = venta;
	}
	public ArrayList<DetalleVentaModel> getDetalle() {
		return detalle;
	}
	public void setDetalle(ArrayList<DetalleVentaModel> detalle) {
		this.detalle = detalle;
	}

}
