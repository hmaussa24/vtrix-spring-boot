package com.stores.stores.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stores.stores.dto.InventarioProductoDTO;
import com.stores.stores.models.ImegesModel;
import com.stores.stores.models.ProductoModel;
import com.stores.stores.models.utils.ResponseError;
import com.stores.stores.services.ImagenesService;
import com.stores.stores.services.InventarioService;
import com.stores.stores.services.ProductoService;

@RestController
@RequestMapping(path = "/api/producto")
public class ProductoController {

	@Autowired
	ProductoService productoService;

	@Autowired
	ImagenesService imagenesService;

	@Autowired
	InventarioService inventarioService;

	@PostMapping(path = "/registrar")
	public ProductoModel guardarProducto(@RequestBody ProductoModel producto) {
		return productoService.guardarProducto(producto);
	}

	@GetMapping(path = "/listar/{tienda}")
	public ArrayList<ProductoModel> listarByTienda(@PathVariable("tienda") Long id) {

		ArrayList<ProductoModel> productos = productoService.buscarByTienda(id);
		for (ProductoModel prod : productos) {
			ArrayList<ImegesModel> images = imagenesService.buscarPorProducto(prod.getId());
			if (!images.isEmpty()) {
				prod.setImage(images.get(0).getImagen());
			}
		}
		return productos;
	}

	@GetMapping(path = "/listarinventario/{tienda}")
	public ArrayList<InventarioProductoDTO> listarByTiendaInventario(@PathVariable("tienda") Long id) {

		ArrayList<ProductoModel> productos = productoService.buscarByTienda(id);
		ArrayList<InventarioProductoDTO> inventario = new ArrayList<InventarioProductoDTO>();
		for (ProductoModel prod : productos) {
			ArrayList<ImegesModel> images = imagenesService.buscarPorProducto(prod.getId());
			if (!images.isEmpty()) {
				prod.setImage(images.get(0).getImagen());
			}
			InventarioProductoDTO inv = new InventarioProductoDTO();
			inv.setProducto(prod);
			inv.setInventario(inventarioService.buscarByProductoId(prod.getId()));
			inventario.add(inv);
		}

		return inventario;
	}
	
	
	@GetMapping(path = "/listarinventario/{tienda}/{nombre}")
	public ArrayList<InventarioProductoDTO> listarByTiendaInventarioProducto(@PathVariable("nombre") String nombre,
			@PathVariable("tienda") Long id) {
		ArrayList<ProductoModel> productos = productoService.buscarByNombre(nombre, id);
		ArrayList<InventarioProductoDTO> inventario = new ArrayList<InventarioProductoDTO>();
		for (ProductoModel prod : productos) {
			ArrayList<ImegesModel> images = imagenesService.buscarPorProducto(prod.getId());
			if (!images.isEmpty()) {
				prod.setImage(images.get(0).getImagen());
			}
			InventarioProductoDTO inv = new InventarioProductoDTO();
			inv.setProducto(prod);
			inv.setInventario(inventarioService.buscarByProductoId(prod.getId()));
			inventario.add(inv);
		}

		return inventario;
	}

	@GetMapping(path = "/buscarbynombre/{tienda}/{nombre}")
	public ArrayList<ProductoModel> buscarByNombre(@PathVariable("nombre") String nombre,
			@PathVariable("tienda") Long id) {
		ArrayList<ProductoModel> productos = productoService.buscarByNombre(nombre, id);
		for (ProductoModel prod : productos) {
			ArrayList<ImegesModel> images = imagenesService.buscarPorProducto(prod.getId());
			if (!images.isEmpty()) {
				prod.setImage(images.get(0).getImagen());
			}
		}
		return productos;
	}

	@GetMapping(path = "/bucarbycategoria/{tienda}/{cat}")
	public Optional<ProductoModel> buscarByCategoria(@PathVariable("cat") Long cat, @PathVariable("tienda") Long id) {
		return productoService.buscarByCategoria(cat, id);
	}

	@GetMapping(path = "/buscarbycodigo/{tienda}/{codigo}")
	public ResponseEntity<?> buscarByCodigo(@PathVariable("codigo") String codigo, @PathVariable("tienda") Long id) {
		Optional<ProductoModel> producto = productoService.buscarByCodigo(codigo, id);
		if (producto.isPresent()) {
			ArrayList<ImegesModel> images = imagenesService.buscarPorProducto(producto.get().getId());
			producto.get().setImage(images.get(0).getImagen());
			return ResponseEntity.ok(producto);
		}
		return ResponseEntity.ok(new ResponseError("Producto no encontrado", 205));
	}

	@GetMapping(path = "/buscrabydescripcion/{tienda}/{des}")
	public Optional<ProductoModel> buscarByDescripcion(@PathVariable("des") String des, Long id) {
		return productoService.buscarByDescripcion(des, id);
	}

	@GetMapping(path = "/buscrabyid/{prod}")
	public Optional<ProductoModel> buscarById(@PathVariable("prod") Long id) {
		return productoService.buacarById(id);
	}

	@GetMapping(path = "/view-producto/{id}")
	public ResponseEntity<?> buscarByCodigoView(@PathVariable("id") Long id) {
		Optional<ProductoModel> producto = productoService.buacarById(id);
		if (producto.isPresent()) {
			ArrayList<ImegesModel> images = imagenesService.buscarPorProducto(producto.get().getId());
			producto.get().setImage(images.get(0).getImagen());
			return ResponseEntity.ok(producto);
		}
		return ResponseEntity.ok(new ResponseError("Producto no encontrado", 205));
	}

}
