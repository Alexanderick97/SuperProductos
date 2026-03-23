package com.duoc.Gestion.model;

import java.time.LocalDate;

public class Producto {
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

    //Constructor vacio
    public Producto() {
    }

    //Constructor atributos obligatorios
    public Producto(int id, String nombreProducto, String sku, LocalDate fechaIngreso, LocalDate fechaVencimiento) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.sku = sku;
        this.fechaIngreso = fechaIngreso;
        this.fechaVencimiento = fechaVencimiento;
        this.activo = true;
        this.stock = 0;  // Por defecto, stock cero
    }

    public Producto(int id, String nombreProducto, String categoria, String marca, int stock,
                    String sku, String descripcionProducto, LocalDate fechaIngreso,
                    LocalDate fechaVencimiento, double precio) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.categoria = categoria;
        this.marca = marca;
        this.stock = stock;
        this.sku = sku;
        this.descripcionProducto = descripcionProducto;
        this.fechaIngreso = fechaIngreso;
        this.fechaVencimiento = fechaVencimiento;
        this.precio = precio;
        this.activo = true;
    }

    // GETTERS Y SETTERS
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getSku() {
        return sku;
    }
    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }
    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }
    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }
    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isActivo() {
        return activo;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}