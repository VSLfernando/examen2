package com.hospital.examen.mapper;

import com.hospital.examen.modelo.Especialidad;
import com.hospital.examen.modelo.dto.EspecialidadDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EspecialidadMapper {
    EspecialidadDTO toDTO(Especialidad especialidad);

    Especialidad toEntity(EspecialidadDTO especialidadDTO);
}
