package com.hospital.examen.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedicoDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String nro_matricula;
    private String password;
    private List<Long> especialidadesIds; // Usar solo los IDs de las especialidades

    public MedicoDTO(String nombre, String apellido, String email, String telefono, String nro_matricula, String password, List<Long> especialidadesIds) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.nro_matricula = nro_matricula;
        this.password = password;
        this.especialidadesIds = especialidadesIds;
    }
}
