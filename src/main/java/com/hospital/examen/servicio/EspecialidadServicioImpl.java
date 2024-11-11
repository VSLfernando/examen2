package com.hospital.examen.servicio;

import com.hospital.examen.mapper.EspecialidadMapper;
import com.hospital.examen.modelo.Especialidad;
import com.hospital.examen.modelo.Medico;
import com.hospital.examen.modelo.dto.EspecialidadDTO;
import com.hospital.examen.repositorio.EspecialidadRepositorio;
import com.hospital.examen.repositorio.MedicoRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;


@Service
public class EspecialidadServicioImpl implements EspecialidadServicio{

    @Autowired
    private EspecialidadMapper especialidadMapper;

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

    @Override
    public EspecialidadDTO obtenerEspecialidadPorId(Long id) {
        Especialidad especialidad = especialidadRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Especialidad no encontrada"));
        return especialidadMapper.toDTO(especialidad);
    }

    @Override
    @Transactional
    public void actualizarEspecialidad(EspecialidadDTO especialidadDTO) {
//        Especialidad especialidad = especialidadMapper.toEntity(especialidadDTO);
//        especialidadRepositorio.save(especialidad);

        Especialidad especialidadExistente = especialidadRepositorio.findById(especialidadDTO.getId())
                .orElseThrow(() -> new RuntimeException("Especialidad no encontrada"));

        // Actualizar los campos básicos
        especialidadExistente.setNombre(especialidadDTO.getNombre());
        especialidadExistente.setDescripcion(especialidadDTO.getDescripcion());

        // Obtener la lista de médicos actualizada
        List<Medico> nuevosMedicos = medicoRepositorio.findAllById(especialidadDTO.getMedicoIds());

        // Limpiar la relación existente
        for (Medico medico : especialidadExistente.getMedicos()) {
            medico.getEspecialidades().remove(especialidadExistente);
        }

        // Actualizar la relación con los nuevos médicos
        especialidadExistente.setMedicos(nuevosMedicos);
        for (Medico medico : nuevosMedicos) {
            medico.getEspecialidades().add(especialidadExistente);
        }

        // Guardar la especialidad actualizada
        especialidadRepositorio.save(especialidadExistente);
    }

    @Override
    public EspecialidadDTO obtenerPorId(Long id) {
        Especialidad especialidad = especialidadRepositorio.findById(id).orElseThrow(() -> new NoSuchElementException("Especialidad no encontrada"));
        EspecialidadDTO dto = new EspecialidadDTO();
        dto.setId(especialidad.getId());
        dto.setNombre(especialidad.getNombre());
        dto.setDescripcion(especialidad.getDescripcion());
        dto.setMedicoIds(especialidad.getMedicos().stream().map(Medico::getId).collect(Collectors.toList()));

        return dto;
    }

    @Override
    public Especialidad guardarEspecialidad(Especialidad especialidad) {
        return especialidadRepositorio.save(especialidad);
    }
}
