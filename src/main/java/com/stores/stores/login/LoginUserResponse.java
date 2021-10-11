package com.stores.stores.login;

public class LoginUserResponse {
 private String email;
 private Long id;
 private String nombre;
 private int rol;
 private String token;
 private Long tienda_id;
 private String nombreTienda;
public String getNombreTienda() {
	return nombreTienda;
}
public void setNombreTienda(String nombreTienda) {
	this.nombreTienda = nombreTienda;
}
public Long getTienda_id() {
	return tienda_id;
}
public void setTienda_id(Long tienda_id) {
	this.tienda_id = tienda_id;
}
public String getToken() {
	return token;
}
public void setToken(String token) {
	this.token = token;
}
public int getRol() {
	return rol;
}
public void setRol(int rol) {
	this.rol = rol;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
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
}
