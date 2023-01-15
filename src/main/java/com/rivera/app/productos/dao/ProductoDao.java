package com.rivera.app.productos.dao;

import org.springframework.data.repository.CrudRepository;

import com.rivera.app.productos.models.entity.Producto;

public interface ProductoDao extends CrudRepository<Producto, Long> {
	

}
