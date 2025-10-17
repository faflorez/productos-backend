package com.empresa.productos_backend.service.impl;

import com.empresa.productos_backend.exception.ResourceNotFoundException;
import com.empresa.productos_backend.model.Producto;
import com.empresa.productos_backend.repository.ProductoRepository;
import com.empresa.productos_backend.service.ProductoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository repo;
    public ProductoServiceImpl(ProductoRepository repo) { this.repo = repo; }

    @Override
    public List<Producto> findAll() {
        return repo.findAll();
    }

    @Override
    public Producto findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con id " + id));
    }

    @Override
    public Producto save(Producto producto) {
        return repo.save(producto);
    }

    @Override
    public Producto update(Long id, Producto producto) {
        Producto existente = findById(id);
        existente.setNombre(producto.getNombre());
        existente.setPrecio(producto.getPrecio());
        existente.setCantidad(producto.getCantidad());
        return repo.save(existente);
    }

    @Override
    public void delete(Long id) {
        Producto p = findById(id);
        repo.delete(p);
    }
}
