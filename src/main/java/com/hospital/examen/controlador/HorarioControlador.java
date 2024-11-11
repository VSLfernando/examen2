package com.hospital.examen.controlador;

import com.hospital.examen.modelo.Horario;
import com.hospital.examen.modelo.Medico;
import com.hospital.examen.servicio.HorarioServicio;
import com.hospital.examen.servicio.MedicoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HorarioControlador {

    @Autowired
    private HorarioServicio horarioServicio;

    @Autowired
    private MedicoServicio medicoServicio; // Para obtener los médicos disponibles

    // Mostrar la lista de especilaidades
    @GetMapping("/horario")
    public String verIndexMedico(Model modelo) {
        modelo.addAttribute("horarios", horarioServicio.listarHorarios());
        return "horario/index"; // Ruta correcta para la vista 'index.html' en la carpeta 'especialidad'
    }

    // Formulario para agregar un nuevo horario
    @GetMapping("/horario/nuevo")
    public String mostrarFormularioNuevoHorario(Model modelo) {
        Horario horario = new Horario(); // Crear un nuevo objeto de horario vacío
        modelo.addAttribute("horario", horario);
        modelo.addAttribute("medicos", medicoServicio.listarMedicos()); // Obtener los médicos para el formulario
        return "horario/nuevo"; // Vista para añadir el horario
    }

    @PostMapping("/horario/nuevo")
    public String guardarHorario(@ModelAttribute Horario horario, Model model) {
        // Obtener el médico a partir del ID recibido en el formulario
        Medico medico = medicoServicio.obtenerMedicoPorId(horario.getMedico().getId());
        horario.setMedico(medico);

        // Guardar el horario
        horarioServicio.guardarHorario(horario);
        model.addAttribute("mensaje", "Horario guardado.");
        return "redirect:/horario";
    }

    // Método para mostrar la página de edición
    @GetMapping("/horario/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Horario horario = horarioServicio.obtenerPorId(id);
        List<Medico> medicos = medicoServicio.listarMedicos();
        model.addAttribute("horario", horario);
        model.addAttribute("medicos", medicos);
        return "horario/editar";
    }

    // Método para actualizar el horario
    @PostMapping("/horario/editar/{id}")
    public String actualizarHorario(@PathVariable Long id, @ModelAttribute("horario") Horario horario) {
        // Obtener el horario existente desde la base de datos
        Horario horarioExistente = horarioServicio.obtenerPorId(id);
        horarioExistente.setDiaSemana(horario.getDiaSemana());
        horarioExistente.setHoraInicio(horario.getHoraInicio());
        horarioExistente.setHoraFin(horario.getHoraFin());
        horarioExistente.setMedico(horario.getMedico());

        // Guardar los cambios
        horarioServicio.guardarHorario(horarioExistente);
        return "redirect:/horario";
    }
}
