package com.stores.stores.models;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "ventas")
public class VentaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	@Column(name = "total", nullable = false)
	private Long total;
	@Column(name = "estado", nullable = false)
	private int estado;
	@Column(name = "tipo", nullable = false)
	private int tipo;// tipo 0 contado, 1 credito
	@Column(name = "fecha_venta", nullable = false)
	private String fecha;
	@Column(name = "impuesto")
	private int impuesto;
	@Column(name = "serie_comprovante")
	private String serieComprovante;
	@Column(name = "num_comprovante")
	private String numComprovante;
	@ManyToOne()
	@JoinColumn(name = "cliente_id", nullable = false)
	private ClienteModel cliente;
	@ManyToOne()
	@JoinColumn(name = "tienda_id", nullable = false)
	private TiendaModel tienda;
	@ManyToOne()
	@JoinColumn(name = "empleado_id", nullable = false)
	private EmpleadosModel empleado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(int impuesto) {
		this.impuesto = impuesto;
	}

	public String getSerieComprovante() {
		return serieComprovante;
	}

	public void setSerieComprovante(String serieComprovante) {
		this.serieComprovante = serieComprovante;
	}

	public String getNumComprovante() {
		return numComprovante;
	}

	public void setNumComprovante(String numComprovante) {
		this.numComprovante = numComprovante;
	}

	public ClienteModel getCliente() {
		return cliente;
	}

	public void setCliente(ClienteModel cliente) {
		this.cliente = cliente;
	}

	public EmpleadosModel getEmpleado() {
		return empleado;
	}

	public void setEmpleado(EmpleadosModel empleado) {
		this.empleado = empleado;
	}

	public TiendaModel getTienda() {
		return tienda;
	}

	public void setTienda(TiendaModel tienda) {
		this.tienda = tienda;
	}
	

}
