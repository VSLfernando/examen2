package com.hospital.examen.controlador;

import com.hospital.examen.modelo.Medico;
import com.hospital.examen.modelo.dto.MedicoDTO;
import com.hospital.examen.servicio.MedicoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MedicoControlador {

    @Autowired
    private MedicoServicio medicoServicio;

    // Mostrar la lista de médicos
    @GetMapping("/medico")
    public String verIndexMedico(Model modelo) {
        modelo.addAttribute("medicos", medicoServicio.listarMedicos());
        return "medico/index"; // Ruta correcta para la vista 'index.html' en la carpeta 'medico'
    }

    // Mostrar formulario para registrar un nuevo médico
    @GetMapping("/medico/nuevo")
    public String mostrarFormularioNuevoMedico(Model modelo) {
        modelo.addAttribute("medico", new MedicoDTO());
        return "medico/nuevo"; // Ruta correcta para la vista 'nuevo.html' en la carpeta 'medico'
    }

    // Registrar un nuevo médico
    @PostMapping("/medico/nuevo")
    public String registrarNuevoMedico(@ModelAttribute("medico") MedicoDTO medicoDTO) {
        medicoServicio.save(medicoDTO);
        return "redirect:/medico"; // Redirige correctamente a la lista de médicos
    }

    // Mostrar el formulario de edición
    @GetMapping("/medico/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Medico medico = medicoServicio.obtenerMedicoPorId(id);
        model.addAttribute("medico", medico);
        return "medico/editar"; // Página de edición
    }

    // Procesar el formulario de edición
    @PostMapping("/medico/actualizar")
    public String actualizarMedico(@ModelAttribute("medico") MedicoDTO medicoDTO) {
        medicoServicio.actualizarMedico(medicoDTO);
        return "redirect:/medico"; // Redirige a la lista de médicos después de actualizar
    }
}
