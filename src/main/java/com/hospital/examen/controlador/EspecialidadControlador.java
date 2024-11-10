package com.hospital.examen.controlador;

import com.hospital.examen.servicio.EspecialidadServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class EspecialidadControlador {

    @Autowired
    private EspecialidadServicio especialidadServicio;

     // Mostrar la lista de especilaidades
    @GetMapping("/especialidad")
    public String verIndexMedico(Model modelo) {
        modelo.addAttribute("especilidades", especialidadServicio.listarEspecialidades());
        return "especialidad/index"; // Ruta correcta para la vista 'index.html' en la carpeta 'especialidad'
    }
}

