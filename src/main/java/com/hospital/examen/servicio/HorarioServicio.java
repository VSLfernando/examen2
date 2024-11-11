package com.hospital.examen.servicio;

import com.hospital.examen.modelo.Horario;

import java.util.List;

public interface HorarioServicio {
    public List<Horario> listarHorarios();
    public void guardarHorario(Horario horario);
    Horario obtenerPorId(Long id);
}
