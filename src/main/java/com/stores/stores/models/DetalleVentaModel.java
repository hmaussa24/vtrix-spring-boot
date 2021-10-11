package com.stores.stores.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_venta")
public class DetalleVentaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	@Column(name = "cantidad", nullable = false)
	private Integer cantidad;
	@Column(name = "precio", nullable = false)
	private Long precio;
	@Column(name = "descuento")
	private Long descuento;
	@ManyToOne()
	@JoinColumn(name = "venta_id", nullable = false)
	private VentaModel venta;
	@ManyToOne()
	@JoinColumn(name = "producto_id", nullable = false)
	private ProductoModel producto;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Long getPrecio() {
		return precio;
	}
	public void setPrecio(Long precio) {
		this.precio = precio;
	}
	public Long getDescuento() {
		return descuento;
	}
	public void setDescuento(Long descuento) {
		this.descuento = descuento;
	}
	public VentaModel getVenta() {
		return venta;
	}
	public void setVenta(VentaModel venta) {
		this.venta = venta;
	}
	public ProductoModel getProducto() {
		return producto;
	}
	public void setProducto(ProductoModel producto) {
		this.producto = producto;
	}
	
}
