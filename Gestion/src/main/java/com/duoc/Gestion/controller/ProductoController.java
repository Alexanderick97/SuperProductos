package com.duoc.Gestion.controller;

import com.duoc.Gestion.model.Producto;
import com.duoc.Gestion.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    // GET /producto
    @GetMapping
    public ResponseEntity<List<Producto>> obtenerProductos() {
        return ResponseEntity.ok(productoService.listarProducto());
    }

    // GET /producto/{id}
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerProductoPorId(@PathVariable int id) {
        Producto producto = productoService.buscarProductoPorId(id);
        if (producto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado");
        }
        return ResponseEntity.ok(producto);
    }

    // GET /producto/categoria/{categoria} ---
    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<?> obtenerProductosPorCategoria(@PathVariable String categoria) {
        List<Producto> productos = productoService.listarProductosPorCategoria(categoria);
        if (productos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron productos en la categoría: " + categoria);
        }
        return ResponseEntity.ok(productos);
    }

    // GET /producto/activos ---
    @GetMapping("/activos")
    public ResponseEntity<List<Producto>> obtenerProductosActivos() {
        List<Producto> productos = productoService.listarProductosActivos();
        return ResponseEntity.ok(productos);
    }

    // /producto/stock/bajo ---
    @GetMapping("/stock/bajo")
    public ResponseEntity<List<Producto>> obtenerProductosStockBajo() {
        List<Producto> productos = productoService.listarProductosStockBajo();
        return ResponseEntity.ok(productos);
    }

    // POST /producto
    @PostMapping
    public ResponseEntity<?> crearProducto(@RequestBody Producto producto) {
        Producto nuevoProducto = productoService.agregarProducto(producto);
        if (nuevoProducto == null) {
            // Si el service devuelve null, significa que la validación falló
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Datos del producto inválidos. Asegúrate de que 'nombreProducto' y 'sku' no estén vacíos.");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto);
    }

    // Endpoint PUT para actualizar
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarProducto(@PathVariable int id, @RequestBody Producto producto) {
        Producto productoActualizado = productoService.actualizarProducto(id, producto);
        if (productoActualizado == null) {
            // Podría ser por datos inválidos o porque el producto no existe.
            // Primero verificamos si el producto existe para dar un mensaje más preciso.
            Producto productoExistente = productoService.buscarProductoPorId(id);
            if (productoExistente == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado");
            } else {
                // Si existe pero la actualización falló, es por datos inválidos
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Datos del producto inválidos para actualizar.");
            }
        }
        return ResponseEntity.ok(productoActualizado);
    }

    // Endpoint DELETE para eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable int id) {
        boolean eliminado = productoService.eliminarProducto(id);
        if (!eliminado) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado");
        }
        return ResponseEntity.ok("Producto eliminado correctamente");
    }
}