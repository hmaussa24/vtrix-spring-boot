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
import com.stores.stores.models.utils.CiudadesModel;

@Entity
@Table(name = "tiendas")
public class TiendaModel{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(name = "nombre", length = 200, nullable = false)
	private String nombre;

	@Column(name = "img")
	private String image;

	@Column(name = "email", length = 200, nullable = false)
	private String email;

	@Column(name = "direccion", length = 200, nullable = false)
	private String direccion;

	@Column(name = "tipo", length = 1)
	private int tipo;

	@Column(name = "telefono", length = 15, nullable = false)
	private String telefono;

	@Column(name = "descripcion", length = 250, nullable = false)
	private String descripcion;

	@ManyToOne()
	@JoinColumn(name = "ciudad_id", nullable = false)
	private CiudadesModel ciudad;

	@ManyToOne()
	@JoinColumn(name = "usuario_id", nullable = false)
	private UsuarioModel usuario;

	public Long getId() {
		return id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public UsuarioModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public CiudadesModel getCiudad() {
		return ciudad;
	}

	public void setCiudad(CiudadesModel ciudad) {
		this.ciudad = ciudad;
	}
}
