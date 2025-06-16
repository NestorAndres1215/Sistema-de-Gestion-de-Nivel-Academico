package com.example.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.model.Estudiante;
import com.example.service.EstudianteService;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    // Lista de estudiantes
    @GetMapping
    public String listarEstudiantes(Model model) {
        List<Estudiante> estudiantes = estudianteService.listarEstudiantes();
        model.addAttribute("estudiantes", estudiantes);
        return "estudiante/lista";
    }

    // Mostrar formulario de registro
    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        return "estudiante/formulario";
    }

    // Guardar estudiante
    @PostMapping("/guardar")
    public String guardarEstudiante(@ModelAttribute Estudiante estudiante, Model model) {
        try {
            estudianteService.guardar(estudiante);
            return "redirect:/estudiantes";
        } catch (IllegalArgumentException e) {
            model.addAttribute("estudiante", estudiante);
            model.addAttribute("error", e.getMessage());
            return "estudiante/formulario";
        }
    }

    // Buscar por nombre (opcional en barra de búsqueda)
    @GetMapping("/buscar")
    public String buscarPorNombre(@RequestParam("nombre") String nombre, Model model) {
        List<Estudiante> estudiantes = estudianteService.buscarPorNombre(nombre);
        model.addAttribute("estudiantes", estudiantes);
        return "estudiante/lista";
    }

    // Mostrar formulario para editar
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Estudiante estudiante = estudianteService.buscarPorId(id);
        if (estudiante != null) {
            model.addAttribute("estudiante", estudiante);
            return "estudiante/formulario";
        } else {
            return "redirect:/estudiantes";
        }
    }

    // Actualizar estudiante
    @PostMapping("/actualizar/{id}")
    public String actualizar(@PathVariable Long id, @ModelAttribute Estudiante estudiante, Model model) {
        try {
            estudianteService.actualizarEstudiante(id, estudiante);
            return "redirect:/estudiantes";
        } catch (IllegalArgumentException e) {
            model.addAttribute("estudiante", estudiante);
            model.addAttribute("error", e.getMessage());
            return "estudiante/formulario";
        }
    }
}