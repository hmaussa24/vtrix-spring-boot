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
@Table(name = "Pagos")
public class PagosModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private Long id;
	@ManyToOne()
	@JoinColumn(name = "credito_id", nullable = false)
	private CreditoModel credito;
	@Column(name = "fecha_pago", nullable = false)
	private String fecha;
	@Column(name = "valor_pago", nullable = false)
	private Long valor;

	public Long getValor() {
		return valor;
	}

	public void setValor(Long valor) {
		this.valor = valor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CreditoModel getCredito() {
		return credito;
	}

	public void setCredito(CreditoModel credito) {
		this.credito = credito;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

}
