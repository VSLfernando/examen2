package com.hospital.examen.servicio;

import com.hospital.examen.modelo.Horario;
import com.hospital.examen.repositorio.HorarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class HorarioServicioImpl implements HorarioServicio{

    @Autowired
    private HorarioRepositorio horarioRepositorio;

    @Override
    public List<Horario> listarHorarios() {
        return horarioRepositorio.findAll();
    }

    @Override
    public void guardarHorario(Horario horario) {
        horarioRepositorio.save(horario); // Guardar el horario en la base de datos
    }

    @Override
    public Horario obtenerPorId(Long id) {
        // Usamos `orElseThrow` para manejar el caso donde el horario no existe
        return horarioRepositorio.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No se encontró el horario con id: " + id));
    }
}
