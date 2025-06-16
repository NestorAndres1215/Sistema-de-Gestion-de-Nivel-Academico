package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.NivelAcademico;
import com.example.service.NivelAcademicoService;

@Controller
@RequestMapping("/nivel-academico")
public class NivelAcademicoController {

    @Autowired
    private NivelAcademicoService nivelAcademicoService;

   @GetMapping
public String listarNiveles(@RequestParam(required = false) String estado, Model model) {
    List<NivelAcademico> niveles;

    if (estado != null && !estado.isEmpty()) {
        niveles = nivelAcademicoService.buscarPorEstado(estado); // 🔽 clave
    } else {
        niveles = nivelAcademicoService.listar();
    }

    model.addAttribute("niveles", niveles);
    model.addAttribute("estadoSeleccionado", estado);
    return "nivel-academico/lista";
}

}