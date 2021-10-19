package com.stores.stores.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stores.stores.dto.ReporteMes;
import com.stores.stores.models.InventarioModel;

@Repository
public interface InventarioRespository extends CrudRepository<InventarioModel, Long> {
	
	public abstract InventarioModel findByProductoId(Long id);
	
	@Query(value = "SELECT MONTHNAME(fecha_venta) AS mes , SUM(total) AS total FROM ventas WHERE YEAR(fecha_venta)=:anio  AND tienda_id=:tienda AND tipo=1 GROUP by MONTH(fecha_venta)" , nativeQuery = true)
	public abstract ArrayList<ReporteMes> reporteInventariMes(@Param("anio")  String anio, @Param("tienda")  Long tienda);
	
	@Query(value = "SELECT MONTHNAME(fecha_venta) AS mes , SUM(total) AS total FROM ventas WHERE YEAR(fecha_venta)=:anio  AND tienda_id=:tienda AND tipo=2 GROUP by MONTH(fecha_venta)" , nativeQuery = true)
	public abstract ArrayList<ReporteMes> reporteVentasMesCredito(@Param("anio")  String anio, @Param("tienda")  Long tienda);

}
