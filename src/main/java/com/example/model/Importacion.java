package com.example.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Importacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo; // Excel o XML

    private LocalDateTime fecha = LocalDateTime.now();

    @Column(name = "archivo_nombre")
    private String archivoNombre;

    // Constructor vacío
    public Importacion() {
    }

    // Constructor con parámetros
    public Importacion(Long id, String tipo, LocalDateTime fecha, String archivoNombre) {
        this.id = id;
        this.tipo = tipo;
        this.fecha = fecha;
        this.archivoNombre = archivoNombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getArchivoNombre() {
        return archivoNombre;
    }

    public void setArchivoNombre(String archivoNombre) {
        this.archivoNombre = archivoNombre;
    }
}