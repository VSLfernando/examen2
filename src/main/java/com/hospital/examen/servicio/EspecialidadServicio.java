package com.hospital.examen.servicio;

import com.hospital.examen.modelo.Especialidad;
import com.hospital.examen.modelo.Medico;
import com.hospital.examen.modelo.dto.EspecialidadDTO;

import java.util.List;
import java.util.Set;

public interface EspecialidadServicio {

    public List<Especialidad> listarEspecialidades();

}
