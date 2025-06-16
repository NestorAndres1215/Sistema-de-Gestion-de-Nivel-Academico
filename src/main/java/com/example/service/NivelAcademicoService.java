package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Estudiante;
import com.example.model.NivelAcademico;
import com.example.repository.NivelAcademicoRepository;

@Service
public class NivelAcademicoService {

    @Autowired
    private NivelAcademicoRepository nivelAcademicoRepository;

    public void calcularNivelAcademico(Estudiante estudiante, double promedio) {
        NivelAcademico nivel = nivelAcademicoRepository.findByEstudiante(estudiante);
        if (nivel == null) {
            nivel = new NivelAcademico();
            nivel.setEstudiante(estudiante);
        }
        nivel.setPromedio(promedio);
        nivel.setEstado(promedio >= 11 ? "Aprobado" : "Desaprobado");
        nivelAcademicoRepository.save(nivel);
    }

    public List<NivelAcademico> listar() {
        return nivelAcademicoRepository.findAll();
    }

    public NivelAcademico obtenerPorEstudiante(Long estudianteId) {
        return nivelAcademicoRepository.findByEstudianteId(estudianteId);
    }
    public List<NivelAcademico> buscarPorEstado(String estado) {
    return nivelAcademicoRepository.findByEstado(estado);
}
}