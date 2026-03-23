package com.duoc.Gestion.model;

public class Bodega {
    // ATRIBUTOS
    private int id;
    private String nombreBodega;
    private String descripcionBodega;

    public Bodega() {
    }

    public Bodega(int id, String nombreBodega, String descripcionBodega) {
        this.id = id;
        this.nombreBodega = nombreBodega;
        this.descripcionBodega = descripcionBodega;
    }

    // GETTERS Y SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreBodega() {
        return nombreBodega;
    }

    public void setNombreBodega(String nombreBodega) {
        this.nombreBodega = nombreBodega;
    }

    public String getDescripcionBodega() {
        return descripcionBodega;
    }

    public void setDescripcionBodega(String descripcionBodega) {
        this.descripcionBodega = descripcionBodega;
    }
}