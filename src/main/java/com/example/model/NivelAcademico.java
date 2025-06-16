package com.example.model;

import jakarta.persistence.*;

@Entity
public class NivelAcademico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;

    private Double promedio;
    private String estado;

    // Getters y Setters
    public NivelAcademico() {
    }

    public NivelAcademico(Long id, Estudiante estudiante, Double promedio, String estado) {
        this.id = id;
        this.estudiante = estudiante;
        this.promedio = promedio;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Double getPromedio() {
        return promedio;
    }

    public void setPromedio(Double promedio) {
        this.promedio = promedio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}