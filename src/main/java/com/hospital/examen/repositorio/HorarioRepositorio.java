package com.hospital.examen.repositorio;

import com.hospital.examen.modelo.Horario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HorarioRepositorio extends JpaRepository<Horario, Long> {
}
