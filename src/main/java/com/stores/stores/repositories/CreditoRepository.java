package com.stores.stores.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stores.stores.models.CreditoModel;

@Repository
public interface CreditoRepository extends CrudRepository<CreditoModel, Long> {
	@Query(value = "SELECT cr.* FROM clientes c, ventas v, creditos cr WHERE c.cedula=:cedula AND v.cliente_id=c.id AND v.tipo=1 AND cr.venta_id=v.id", nativeQuery = true)
	public abstract ArrayList<CreditoModel> buscarByCedula(@Param("cedula") String cedula);
	
	public abstract ArrayList<CreditoModel> findByTiendaId(Long id);

}
