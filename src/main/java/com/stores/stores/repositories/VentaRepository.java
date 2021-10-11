package com.stores.stores.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stores.stores.models.VentaModel;

@Repository
public interface VentaRepository extends CrudRepository<VentaModel, Long> {
	
	
	@Query(value = "SELECT * FROM ventas WHERE ventas.fecha_venta like %:fecha%", nativeQuery = true)
	public abstract ArrayList<VentaModel> ventasByFechaVenta(@Param("fecha") String fecha);

}
