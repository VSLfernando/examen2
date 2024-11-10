package com.hospital.examen.controlador;

import com.hospital.examen.modelo.Medico;
import com.hospital.examen.modelo.dto.EspecialidadDTO;
import com.hospital.examen.servicio.EspecialidadServicio;
import com.hospital.examen.servicio.MedicoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller

public class EspecialidadControlador {

    @Autowired
    private EspecialidadServicio especialidadServicio;

    @Autowired
    private MedicoServicio medicoServicio;

     // Mostrar la lista de especilaidades
    @GetMapping("/especialidad")
    public String verIndexMedico(Model modelo) {
        modelo.addAttribute("especialidades", especialidadServicio.listarEspecialidades());
        return "especialidad/index"; // Ruta correcta para la vista 'index.html' en la carpeta 'especialidad'
    }

    // Mostrar el formulario para añadir una nueva especialidad
    @GetMapping("/especialidad/nuevo")
    public String mostrarFormulario(Model modelo) {
        EspecialidadDTO especialidadDTO = new EspecialidadDTO();
        List<Medico> medicos = medicoServicio.listarMedicos(); // Obtener la lista de médicos
        modelo.addAttribute("especialidadDTO", especialidadDTO);
        modelo.addAttribute("medicos", medicos);
        return "especialidad/nuevo"; // Ruta al formulario de especialidad
    }

    // Procesar el formulario para guardar la nueva especialidad
    @PostMapping("/especialidad/nuevo")
    public String registrarEspecialidad(EspecialidadDTO especialidadDTO) {
        especialidadServicio.crearEspecialidad(especialidadDTO);
        return "redirect:/especialidad"; // Redirigir a la lista de especialidades
    }
}

