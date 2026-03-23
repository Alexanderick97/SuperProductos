package com.duoc.Gestion.repository;

import com.duoc.Gestion.model.Producto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductoRepository {
    private final List<Producto> listaProducto = new ArrayList<>();

    public List<Producto> obtenerTodos() {
        return listaProducto;
    }

    public Producto obtenerPorId(int id) {
        for (Producto producto : listaProducto) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }

    public Producto guardar(Producto producto) {
        listaProducto.add(producto);
        return producto;
    }

    public Producto actualizar(int id, Producto productoActualizado) {
        for (int i = 0; i < listaProducto.size(); i++) {
            Producto productoExistente = listaProducto.get(i);
            if (productoExistente.getId() == id) {
                // Mantenemos el ID original
                productoActualizado.setId(id);
                // Reemplazamos el objeto en la lista
                listaProducto.set(i, productoActualizado);
                return productoActualizado;
            }
        }
        return null; // Indica que no se encontró el producto a actualizar
    }

    public boolean eliminar(int id) {
        for (int i = 0; i < listaProducto.size(); i++) {
            if (listaProducto.get(i).getId() == id) {
                listaProducto.remove(i);
                return true; // Indica que se eliminó correctamente
            }
        }
        return false; // Indica que no se encontró el producto a eliminar
    }
}