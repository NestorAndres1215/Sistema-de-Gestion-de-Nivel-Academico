package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    // Puedes agregar métodos personalizados si los necesitas luego
    boolean existsByDni(String dni);

    List<Estudiante> findByNombreContainingIgnoreCase(String nombre);
}
