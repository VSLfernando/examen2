package com.hospital.examen.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EspecialidadDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private Long medicoId; // Usar solo el ID del médico en lugar de la entidad completa

    public EspecialidadDTO(String nombre, String descripcion, Long medicoId) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.medicoId = medicoId;
    }
}
