package com.stores.stores.repositories;

import java.util.ArrayList;
import java.util.Optional;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stores.stores.models.ProductoModel;

@Repository
public interface ProductoRepository extends CrudRepository<ProductoModel, Long> {
	@Query(value = "SELECT * FROM productos p WHERE codigo=:codigo AND tienda_id=:id_tienda ", nativeQuery = true)
	public abstract Optional<ProductoModel> findByCodigo(@Param("codigo") String codigo, @Param("id_tienda") Long id);

	@Query(value = "SELECT * FROM productos p WHERE ( nombre LIKE %:nombre% OR codigo LIKE %:nombre% ) AND tienda_id=:id_tienda", nativeQuery = true)
	public ArrayList<ProductoModel> findByNombreAndTienda(@Param("nombre") String nombre, @Param("id_tienda") Long id);

	@Query(value = "SELECT p FROM productos p WHERE descripcion=:des AND tienda_id=:id_tienda", nativeQuery = true)
	public Optional<ProductoModel> findByDescripcionAndTienda(@Param("des") String des, @Param("id_tienda") Long id);

	@Query(value = "SELECT p FROM productos p WHERE categoria_id=:cat AND tienda_id=:id_tienda", nativeQuery = true)
	public Optional<ProductoModel> findByCategoriaAndTienda(@Param("cat") Long cat, @Param("id_tienda") Long id);

	public abstract ArrayList<ProductoModel> findByTiendaId(Long id);
}
