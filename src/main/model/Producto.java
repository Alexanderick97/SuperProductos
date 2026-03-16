package com.productos.Super.model;

import java.time.LocalDate;  // Para manejar fechas (Java 8+)
import java.time.temporal.ChronoUnit; // Para calcular días entre fechas

public class Producto
{
    // ATRIBUTOS
    private int id;
    private String nombreProducto;
    private String categoria;
    private String marca;
    private int stock;
    private String sku;
    private String descripcionProducto;
    private LocalDate fechaIngreso;
    private LocalDate fechaVencimiento;
    private double precio;
    private boolean activo;

}

//Constructor vacio
public Producto{} {
    this.activo = true;
}

//Constructor atributos obligatorios
public Producto(int id, String nombre, String sku, LocalDate fechaIngreso, LocalDate fechaVencimiento) {
    this.id = id;
    this.nombreProducto = nombreProducto;
    this.sku = sku;
    this.fechaIngreso = fechaIngreso;
    this.fechaVencimiento = fechaVencimiento;
    this.activo = true;
    this.stock = 0;  // Por defecto, stock cero
}

//Constructor con todos los atributos
public Producto(int id, String nombre, Categoria categoria, String marca, int stock, 
                String sku, String descripcion, LocalDate fechaIngreso, 
                LocalDate fechaVencimiento, Proveedor proveedor, double precio) {
    this.id = id;
    this.descripcionProducto = descripcionProducto;
    this.categoria = categoria;
    this.marca = marca;
    this.stock = stock;
    this.sku = sku;
    this.descripcionProducto = descripcionProducto;
    this.fechaIngreso = fechaIngreso;
    this.fechaVencimiento = fechaVencimiento;
    this.proveedor = proveedor;
    this.precio = precio;
    this.activo = true;
}

Producto producto1 = new Producto(
    001, 
    "galletas", 
    "golosinas", 
    "Galleteco", 
    100, 
    "GA001", 
    "Galletas rellenas de chocolate",
    LocalDate.of(2024, 3, 1),
    LocalDate.of(2024, 6, 30),
    1500,
    true
)