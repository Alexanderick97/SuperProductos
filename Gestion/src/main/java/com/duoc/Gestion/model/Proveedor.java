package com.duoc.Gestion.model;

public class Proveedor {
    // ATRIBUTOS
    private int id;
    private String nombreProveedor;
    private String contactoProveedor;

    public Proveedor() {
    }

    public Proveedor(int id, String nombreProveedor, String contactoProveedor) {
        this.id = id;
        this.nombreProveedor = nombreProveedor;
        this.contactoProveedor = contactoProveedor;
    }

    // GETTERS Y SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getContactoProveedor() {
        return contactoProveedor;
    }

    public void setContactoProveedor(String contactoProveedor) {
        this.contactoProveedor = contactoProveedor;
    }
}