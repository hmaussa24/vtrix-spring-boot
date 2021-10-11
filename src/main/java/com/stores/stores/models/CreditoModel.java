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
@Table(name = "creditos")
public class CreditoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, name = "id")
	private Long id;
	@Column(name = "numeroCuotas", nullable = false)
	private Long numcuotas;
	@Column(name = "cuota_inicial", nullable = true)
	private Long cuotaInicial; // no esta en uso
	@Column(name = "porcentgaje_interes", nullable = false)
	private Long interes;
	@Column(name = "valor_cuota_inicial", nullable = false)
	private Long cuota;
	@Column(name = "periodos_cuota")
	private Long periodo;
	@Column(name = "valor_cuotas")
	private Long valorcuotas;
	@ManyToOne()
	@JoinColumn(name = "venta_id", nullable = false)
	private VentaModel venta;
	@ManyToOne()
	@JoinColumn(name = "tienda_id", nullable = false)
	private TiendaModel tienda;
	@Column(name = "estado")
	private int estado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getValorcuotas() {
		return valorcuotas;
	}

	public void setValorcuotas(Long valorcuotas) {
		this.valorcuotas = valorcuotas;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Long getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Long periodo) {
		this.periodo = periodo;
	}

	public Long getNumcuotas() {
		return numcuotas;
	}

	public void setNumcuotas(Long numcuotas) {
		this.numcuotas = numcuotas;
	}

	public Long getCuotaInicial() {
		return cuotaInicial;
	}

	public void setCuotaInicial(Long cuotaInicial) {
		this.cuotaInicial = cuotaInicial;
	}

	public Long getInteres() {
		return interes;
	}

	public void setInteres(Long interes) {
		this.interes = interes;
	}

	public VentaModel getVenta() {
		return venta;
	}

	public void setVenta(VentaModel venta) {
		this.venta = venta;
	}

	public Long getCuota() {
		return cuota;
	}

	public void setCuota(Long cuota) {
		this.cuota = cuota;
	}

	public TiendaModel getTienda() {
		return tienda;
	}

	public void setTienda(TiendaModel tienda) {
		this.tienda = tienda;
	}

}
