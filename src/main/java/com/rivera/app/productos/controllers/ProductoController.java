package com.rivera.app.productos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.core.env.Environment;
import java.util.List;

import com.rivera.app.productos.services.IProductoService;
import com.rivera.app.productos.models.entity.Producto;

@RestController
public class ProductoController {
	
	@Autowired
	private IProductoService productoService;
	
	//Para poder acceder a las variables de entorno de la aplicacion, tambien puedo usar @Value("${server.port}")
	@Autowired
	private Environment variablesProperties;
	
	@GetMapping("/listar-productos")
	public List<Producto> listarProductos(){
		return productoService.encontrarTodos()
				.stream()
				.map(product -> {
					product.setPuerto(Integer.parseInt(variablesProperties.getProperty("local.server.port")));
					return product;
				})
				.toList();
	}
	
	@GetMapping("/producto/{id}")
	public Producto encontrarProducto(@PathVariable Long id) {
		Producto producto = productoService.encontrarUnProducto(id);
		producto.setPuerto(Integer.parseInt(variablesProperties.getProperty("local.server.port")));
		return producto;
	}

}
