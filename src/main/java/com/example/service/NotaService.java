package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Estudiante;
import com.example.model.Nota;
import com.example.repository.NotaRepository;

@Service
public class NotaService {

    private final NotaRepository notaRepository;

    public NotaService(NotaRepository notaRepository) {
        this.notaRepository = notaRepository;
    }

    public List<Nota> listarNotas() {
        return notaRepository.findAll();
    }

    public List<Nota> obtenerNotasPorEstudiante(Long estudianteId) {
        return notaRepository.findByEstudianteId(estudianteId);
    }

    public Nota guardar(Nota nota) {
        return notaRepository.save(nota);
    }

    public boolean validarNotas(Nota nota) {
        return nota.getNota1() != null && nota.getNota1() >= 0 && nota.getNota1() <= 20 &&
                nota.getNota2() != null && nota.getNota2() >= 0 && nota.getNota2() <= 20 &&
                nota.getNota3() != null && nota.getNota3() >= 0 && nota.getNota3() <= 20;
    }

    public Double calcularNotaFinal(Nota nota) {
        return (nota.getNota1() + nota.getNota2() + nota.getNota3()) / 3.0;
    }

    public Nota buscarPorEstudiante(Estudiante estudiante) {
        return notaRepository.findByEstudiante(estudiante);
    }
    
}