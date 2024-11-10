package com.hospital.examen.servicio;

import com.hospital.examen.modelo.Medico;
import com.hospital.examen.modelo.dto.MedicoDTO;

import java.util.List;

public interface MedicoServicio {
    public Medico save(MedicoDTO medicoDTO);
    public List<Medico> listarMedicos();
    public Medico obtenerMedicoPorId(Long id); // Método para obtener el médico por ID
    public Medico actualizarMedico(MedicoDTO medicoDTO); // Método para actualizar el médico
}
