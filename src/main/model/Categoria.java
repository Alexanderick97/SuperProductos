package com.productos.Super.model;

import java.util.ArrayList;
import java.util.List;

public class Categoria
{
    private int id;
    private String nombreCategoria;
    private String descripcionCategoria;
    private String seccion;
    private List<Producto> productos;
}

public Categoria{} {
    this.productos = new ArrayList<>();
}

public Categoria{int id, String nombre, String descripcionCategoria, String seccion} {
    this.id = id
    this.nombreCategoria = nombreCategoria;
    this.descripcionCategoria = descripcionCategoria;
    this.seccion = seccion;
    this.productos = new ArrayList<>();
}