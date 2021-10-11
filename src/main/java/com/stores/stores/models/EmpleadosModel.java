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
@Table(name = "empleados")
public class EmpleadosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
	private Long id;
    @Column(name = "nombre", length = 50, nullable = false)
	private String nombre;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
	@Column(name = "rol", length = 1, nullable = false)
	private int rol;
    @Column(name = "sueldo", length = 8, nullable = false)
	private int sueldo;
    @ManyToOne()
    @JoinColumn(name = "tienda_id")
	private TiendaModel tienda;
    
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
    public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getRol() {
		return rol;
	}
	public void setRol(int rol) {
		this.rol = rol;
	}
	public int getSueldo() {
		return sueldo;
	}
	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}
	public TiendaModel getTienda() {
		return tienda;
	}
	public void setTienda(TiendaModel tienda) {
		this.tienda = tienda;
	}
	
}
