package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.service.EstudianteService;
import com.example.service.NivelAcademicoService;

@Controller
public class HomeController {

   
    @Autowired
    private EstudianteService estudianteService;

    @Autowired
    private NivelAcademicoService nivelAcademicoService;

   
    @GetMapping("/")
    public String index(Model model) {
        long totalEstudiantes = estudianteService.contarEstudiantes();
        long totalNotas = nivelAcademicoService.contarNotasRegistradas();
        Double promedioGeneral = nivelAcademicoService.obtenerPromedioGeneral();

        model.addAttribute("totalEstudiantes", totalEstudiantes);
        model.addAttribute("totalNotas", totalNotas);
        model.addAttribute("promedioGeneral", promedioGeneral);

        return "index"; // Asegúrate que tu HTML esté en templates/admin/dashboard.html
    }
}