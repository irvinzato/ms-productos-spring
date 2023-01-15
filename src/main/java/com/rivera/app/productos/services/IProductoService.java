package com.rivera.app.productos.services;

import java.util.List;

import com.rivera.app.productos.models.entity.Producto;

public interface IProductoService {
	
	public List<Producto> encontrarTodos();
	public Producto encontrarUnProducto(Long id);

}
