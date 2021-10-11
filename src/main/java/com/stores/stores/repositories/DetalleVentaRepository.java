package com.stores.stores.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stores.stores.models.DetalleVentaModel;
import com.stores.stores.models.VentaModel;

@Repository
public interface DetalleVentaRepository extends CrudRepository<DetalleVentaModel, Long>{
	public abstract ArrayList<DetalleVentaModel> findByVenta(VentaModel venta);
}
