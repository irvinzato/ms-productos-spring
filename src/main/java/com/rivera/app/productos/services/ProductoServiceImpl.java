package com.rivera.app.productos.services;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rivera.app.productos.models.entity.Producto;
import com.rivera.app.productos.dao.ProductoDao;

@Service
public class ProductoServiceImpl implements IProductoService{
	
	@Autowired
	private ProductoDao productoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Producto> encontrarTodos() {
		return (List<Producto>) productoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Producto encontrarUnProducto(Long id) {
		return productoDao.findById(id).orElse(null);
	}

}
