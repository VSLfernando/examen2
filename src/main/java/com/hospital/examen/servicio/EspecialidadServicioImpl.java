package com.hospital.examen.servicio;

import com.hospital.examen.modelo.Especialidad;
import com.hospital.examen.modelo.Medico;
import com.hospital.examen.modelo.dto.EspecialidadDTO;
import com.hospital.examen.repositorio.EspecialidadRepositorio;
import com.hospital.examen.repositorio.MedicoRepositorio;
import jakarta.transaction.Transactional;
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

    @Override
    @Transactional
    public void crearEspecialidad(EspecialidadDTO especialidadDTO) {
        Especialidad especialidad = new Especialidad();
        especialidad.setNombre(especialidadDTO.getNombre());
        especialidad.setDescripcion(especialidadDTO.getDescripcion());

        List<Medico> medicos = medicoRepositorio.findAllById(especialidadDTO.getMedicoIds());
        especialidad.setMedicos(medicos);

        // Actualizar la relación bidireccional
        for (Medico medico : medicos) {
            medico.getEspecialidades().add(especialidad);
        }

        especialidadRepositorio.save(especialidad);
    }

}
