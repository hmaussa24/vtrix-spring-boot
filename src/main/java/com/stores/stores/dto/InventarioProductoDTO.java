package com.stores.stores.dto;

import com.stores.stores.models.InventarioModel;
import com.stores.stores.models.ProductoModel;

public class InventarioProductoDTO {

	private ProductoModel producto;
	private InventarioModel inventario;

	public ProductoModel getProducto() {
		return producto;
	}

	public void setProducto(ProductoModel producto) {
		this.producto = producto;
	}

	public InventarioModel getInventario() {
		return inventario;
	}

	public void setInventario(InventarioModel inventario) {
		this.inventario = inventario;
	}

}
