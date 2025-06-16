package com.example.service;

import org.springframework.stereotype.Service;

import com.example.model.Importacion;
import com.example.repository.ImportacionRepository;

import java.util.List;

@Service
public class ImportacionService {

    private final ImportacionRepository importacionRepository;

    public ImportacionService(ImportacionRepository importacionRepository) {
        this.importacionRepository = importacionRepository;
    }

    public Importacion guardar(Importacion importacion) {
        return importacionRepository.save(importacion);
    }

    public List<Importacion> listar() {
        return importacionRepository.findAll();
    }
}
