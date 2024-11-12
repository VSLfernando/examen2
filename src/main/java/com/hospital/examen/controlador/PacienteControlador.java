package com.hospital.examen.controlador;

import com.hospital.examen.servicio.MedicoServicio;
import com.hospital.examen.servicio.PacienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PacienteControlador {
    @Autowired
    private PacienteServicio pacienteServicio;

    // Mostrar la lista de médicos
    @GetMapping("/paciente")
    public String verIndexMedico(Model modelo) {
        modelo.addAttribute("pacientes", pacienteServicio.listarPacientes());
        return "paciente/index"; // Ruta correcta para la vista 'index.html' en la carpeta 'medico'
    }
}
