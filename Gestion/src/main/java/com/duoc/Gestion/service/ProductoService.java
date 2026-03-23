package com.duoc.Gestion.service;

import com.duoc.Gestion.model.Producto;
import com.duoc.Gestion.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    // Constructor
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    // Listar productos
    public List<Producto> listarProducto() {
        return productoRepository.obtenerTodos();
    }

    // Buscar por ID
    public Producto buscarProductoPorId(int id) {
        return productoRepository.obtenerPorId(id);
    }

    public Producto agregarProducto(Producto producto) {
        // Validación completa para crear
        String error = validarProductoParaCrear(producto);
        if (error != null) {
            System.out.println("Error de validación: " + error); // Para depuración
            return null;
        }
        return productoRepository.guardar(producto);
    }

    public Producto actualizarProducto(int id, Producto producto) {
        // Validación completa para actualizar
        String error = validarProductoParaActualizar(producto);
        if (error != null) {
            System.out.println("Error de validación: " + error);
            return null;
        }
        return productoRepository.actualizar(id, producto);
    }

    public boolean eliminarProducto(int id) {
        return productoRepository.eliminar(id);
    }

    // Validación completa para CREAR ---
    private String validarProductoParaCrear(Producto producto) {
        // Validar que el objeto no sea null
        if (producto == null) {
            return "El producto no puede ser nulo";
        }

        // Validar nombre (obligatorio)
        if (producto.getNombreProducto() == null || producto.getNombreProducto().isBlank()) {
            return "El nombre del producto es obligatorio";
        }

        // Validar SKU (obligatorio)
        if (producto.getSku() == null || producto.getSku().isBlank()) {
            return "El SKU del producto es obligatorio";
        }

        // Validar que el SKU no exista ya en otro producto
        for (Producto p : productoRepository.obtenerTodos()) {
            if (p.getSku().equals(producto.getSku())) {
                return "Ya existe un producto con el SKU: " + producto.getSku();
            }
        }

        // Validar precio (no negativo)
        if (producto.getPrecio() < 0) {
            return "El precio no puede ser negativo";
        }

        // Validar stock (no negativo)
        if (producto.getStock() < 0) {
            return "El stock no puede ser negativo";
        }

        // Validar fechas (si están presentes)
        if (producto.getFechaIngreso() != null && producto.getFechaVencimiento() != null) {
            if (producto.getFechaIngreso().isAfter(producto.getFechaVencimiento())) {
                return "La fecha de ingreso no puede ser posterior a la fecha de vencimiento";
            }
        }

        // Si el producto no tiene fecha de ingreso, asignar la fecha actual
        if (producto.getFechaIngreso() == null) {
            producto.setFechaIngreso(LocalDate.now());
        }

        // Asegurar que el producto sea activo por defecto
        // El constructor ya lo hace, pero por si acaso:
        if (producto.isActivo() == false && producto.getFechaIngreso() != null) {
            // Si es un producto nuevo, debería estar activo
            producto.setActivo(true);
        }

        // Validar que la categoría no sea vacía si viene presente
        if (producto.getCategoria() != null && producto.getCategoria().isBlank()) {
            return "La categoría no puede estar vacía si se proporciona";
        }

        return null; // null significa que no hay errores
    }

    // Validación completa para ACTUALIZAR ---
    private String validarProductoParaActualizar(Producto producto) {
        // Validar que el objeto no sea null
        if (producto == null) {
            return "El producto no puede ser nulo";
        }

        // Validar nombre (si viene, no puede estar vacío)
        if (producto.getNombreProducto() != null && producto.getNombreProducto().isBlank()) {
            return "El nombre del producto no puede estar vacío";
        }

        // Metodo auxiliar para obtener productos por categoríalidar SKU (si viene, no puede estar vacío)
        if (producto.getSku() != null && producto.getSku().isBlank()) {
            return "El SKU del producto no puede estar vacío";
        }

        // Validar precio (si viene, no puede ser negativo)
        if (producto.getPrecio() < 0) {
            return "El precio no puede ser negativo";
        }

        // Validar stock (si viene, no puede ser negativo)
        if (producto.getStock() < 0) {
            return "El stock no puede ser negativo";
        }

        // Validar fechas (si vienen ambas)
        if (producto.getFechaIngreso() != null && producto.getFechaVencimiento() != null) {
            if (producto.getFechaIngreso().isAfter(producto.getFechaVencimiento())) {
                return "La fecha de ingreso no puede ser posterior a la fecha de vencimiento";
            }
        }

        // Validar categoría (si viene, no puede estar vacía)
        if (producto.getCategoria() != null && producto.getCategoria().isBlank()) {
            return "La categoría no puede estar vacía";
        }

        return null; // null significa que no hay errores
    }

    // Metodo para obtener por categoria
    public List<Producto> listarProductosPorCategoria(String categoria) {
        if (categoria == null || categoria.isBlank()) {
            return List.of(); // Devuelve lista vacía
        }

        return productoRepository.obtenerTodos().stream()
                .filter(p -> p.getCategoria() != null && p.getCategoria().equalsIgnoreCase(categoria))
                .toList();
    }

    // Metodo para obtener solo productos activos
    public List<Producto> listarProductosActivos() {
        return productoRepository.obtenerTodos().stream()
                .filter(Producto::isActivo)
                .toList();
    }

    // Metodo para obtener productos con stock bajo (menor a 10)
    public List<Producto> listarProductosStockBajo() {
        return productoRepository.obtenerTodos().stream()
                .filter(p -> p.getStock() < 10)
                .toList();
    }
}