package com.rivera.app.productos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

import com.rivera.app.productos.services.IProductoService;
import com.rivera.app.productos.models.entity.Producto;

@RestController
public class ProductoController {
	
	@Autowired
	private IProductoService productoService;
	
	@GetMapping("/listar-productos")
	public List<Producto> listarProductos(){
		return productoService.encontrarTodos();
	}
	
	@GetMapping("/producto/{id}")
	public Producto encontrarProducto(@PathVariable Long id) {
		return productoService.encontrarUnProducto(id);
	}

}
