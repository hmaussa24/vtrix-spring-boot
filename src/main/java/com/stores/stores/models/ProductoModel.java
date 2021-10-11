package com.stores.stores.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "productos")
public class ProductoModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;
	@Column(name = "codigo", nullable = false)
	private String codigo;
	@Column(name = "nombre", nullable = false)
	private String nombre;
	@Column(name = "precio", nullable = false)
	private Long precio;
	@Column(name = "costo", nullable = false)
	private Long costo;
	@Column(name = "descripcion", nullable = false)
	private String descripcion;
	@Column(name = "image")
	private String image;
	@ManyToOne()
	@JoinColumn(name = "categoria_id", nullable = false)
	private CategoriaModel categoria;
	@ManyToOne()
	@JoinColumn(name = "tienda_id", nullable = false)
	private TiendaModel tienda;
	
	@OneToMany(mappedBy = "producto")
	private List<ImegesModel> images;
	

	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public TiendaModel getTienda() {
		return tienda;
	}
	public void setTienda(TiendaModel tienda) {
		this.tienda = tienda;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getPrecio() {
		return precio;
	}
	public void setPrecio(Long precio) {
		this.precio = precio;
	}
	public Long getCosto() {
		return costo;
	}
	public void setCosto(Long costo) {
		this.costo = costo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public CategoriaModel getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaModel categoria) {
		this.categoria = categoria;
	}

}
