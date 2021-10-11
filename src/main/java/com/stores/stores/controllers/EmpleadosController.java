package com.stores.stores.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stores.stores.models.EmpleadosModel;
import com.stores.stores.services.EmpleadosService;

@RestController
@RequestMapping(path = "/api/empleados")
public class EmpleadosController {

	@Autowired
	EmpleadosService empleadoServices;
	
	@PostMapping(path = "/registra")
	public EmpleadosModel guardarEmpleado(@RequestBody EmpleadosModel empleado) {
		return empleadoServices.guardarTienda(empleado);
	}
	
	@GetMapping(path = "/empleados-tienda/{tienda}")
	public ArrayList<EmpleadosModel> getEmpleadosByTienda(@PathVariable("tienda") Long id){
		return empleadoServices.empleadosByTienda(id);
	}
}
