package com.hospital.examen.servicio;

import com.hospital.examen.modelo.Medico;
import com.hospital.examen.modelo.dto.MedicoDTO;
import com.hospital.examen.repositorio.MedicoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicoServicioImpl implements MedicoServicio {

    @Autowired
    private MedicoRepositorio medicoRepositorio;


    @Override
    public Medico save(MedicoDTO medicoDTO) {
        Medico medico = new Medico(medicoDTO.getNombre(),
                medicoDTO.getApellido(),
                medicoDTO.getEmail(),
                medicoDTO.getTelefono(),
                medicoDTO.getNro_matricula(),
                medicoDTO.getPassword());
        return medicoRepositorio.save(medico);
    }

    @Override
    public List<Medico> listarMedicos() {
        return medicoRepositorio.findAll();
    }

    @Override
    public Medico obtenerMedicoPorId(Long id) {
        return medicoRepositorio.findById(id).orElseThrow(() -> new RuntimeException("Médico no encontrado"));
    }

    @Override
    public Medico actualizarMedico(MedicoDTO medicoDTO) {
        // Verificamos si el médico existe
        Medico medicoExistente = obtenerMedicoPorId(medicoDTO.getId());
        medicoExistente.setNombre(medicoDTO.getNombre());
        medicoExistente.setApellido(medicoDTO.getApellido());
        medicoExistente.setEmail(medicoDTO.getEmail());
        medicoExistente.setTelefono(medicoDTO.getTelefono());
        medicoExistente.setNro_matricula(medicoDTO.getNro_matricula());
        // Guardamos los cambios
        return medicoRepositorio.save(medicoExistente);
    }

}
