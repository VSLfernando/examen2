package com.hospital.examen.servicio;

import com.hospital.examen.modelo.Especialidad;
import com.hospital.examen.repositorio.EspecialidadRepositorio;
import com.hospital.examen.repositorio.MedicoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class EspecialidadServicioImpl implements EspecialidadServicio{
    @Autowired
    private EspecialidadRepositorio especialidadRepositorio;

    @Autowired
    private MedicoRepositorio medicoRepositorio;

    @Override
    public List<Especialidad> listarEspecialidades() {
        return especialidadRepositorio.findAll();
    }

}
