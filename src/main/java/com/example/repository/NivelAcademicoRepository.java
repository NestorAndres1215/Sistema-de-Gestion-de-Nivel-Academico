package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Estudiante;
import com.example.model.NivelAcademico;

public interface NivelAcademicoRepository extends JpaRepository<NivelAcademico, Long> {
    NivelAcademico findByEstudiante(Estudiante estudiante);
    NivelAcademico findByEstudianteId(Long id);
    List<NivelAcademico> findByEstado(String estado);
}