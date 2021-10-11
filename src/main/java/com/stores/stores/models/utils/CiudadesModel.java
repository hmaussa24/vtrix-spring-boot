package com.stores.stores.models.utils;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.stores.stores.models.TiendaModel;

@Entity
@Table(name = "ciudades")
public class CiudadesModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre", length = 50)
	private String nombre;
	
	/*@OneToMany(mappedBy = "ciudades", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<TiendaModel> tienda;*/
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/*public List<TiendaModel> getTienda() {
		return tienda;
	}
	public void setTienda(List<TiendaModel> tienda) {
		this.tienda = tienda;
	}*/


}
