package com.empresa.productos_backend.service;

import com.empresa.productos_backend.model.Producto;
import java.util.List;
public interface ProductoService {
    List<Producto> findAll();
    Producto findById(Long id);
    Producto save(Producto producto);
    Producto update(Long id, Producto producto);
    void delete(Long id);
}
