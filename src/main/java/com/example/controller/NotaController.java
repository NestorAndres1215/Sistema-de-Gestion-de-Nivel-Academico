package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.model.Nota;
import com.example.service.EstudianteService;
import com.example.service.NotaService;
import com.example.service.NivelAcademicoService;

@Controller
@RequestMapping("/notas")
public class NotaController {
    private final NotaService notaService;
    private final EstudianteService estudianteService;
    private final NivelAcademicoService nivelAcademicoService;

    public NotaController(NotaService notaService, EstudianteService estudianteService, NivelAcademicoService nivelAcademicoService) {
        this.notaService = notaService;
        this.estudianteService = estudianteService;
        this.nivelAcademicoService = nivelAcademicoService;
    }
    

    @GetMapping
    public String verTodas(Model model) {
        model.addAttribute("notas", notaService.listarNotas());
        return "notas/lista";
    }

    @GetMapping("/nuevo")
    public String nuevaNota(Model model) {
        model.addAttribute("nota", new Nota());
        model.addAttribute("estudiantes", estudianteService.listarEstudiantes());
        return "notas/formulario";
    }

    @PostMapping("/guardar")
    public String guardarNota(@ModelAttribute Nota nota, Model model) {
        // Validación de notas
        if (!notaService.validarNotas(nota)) {
            model.addAttribute("error", "Las notas deben estar entre 0 y 20");
            model.addAttribute("estudiantes", estudianteService.listarEstudiantes());
            return "notas/formulario";
        }

        // Calcular nota final
        Double notaFinal = notaService.calcularNotaFinal(nota);
        nota.setNotaFinal(notaFinal);

        // Guardar nota
        notaService.guardar(nota);

        // Guardar nivel académico con estado según nota final
        nivelAcademicoService.calcularNivelAcademico(nota.getEstudiante(), notaFinal);

        return "redirect:/notas";
    }
}