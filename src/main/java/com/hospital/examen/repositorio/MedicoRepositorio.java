package com.hospital.examen.repositorio;

import com.hospital.examen.modelo.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface MedicoRepositorio extends JpaRepository<Medico, Long> {
    public abstract List<Medico> findAllById(Iterable<Long> ids);


}
