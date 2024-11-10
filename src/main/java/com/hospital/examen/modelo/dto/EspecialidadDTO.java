package com.hospital.examen.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor

public class EspecialidadDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private List<Long> medicoIds; // Lista de IDs de los médicos seleccionados

    public List<Long> getMedicoIds() {
        return medicoIds;
    }

    public void setMedicoIds(List<Long> medicoIds) {
        this.medicoIds = medicoIds;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EspecialidadDTO(List<Long> medicoIds, String descripcion, String nombre) {
        this.medicoIds = medicoIds;
        this.descripcion = descripcion;
        this.nombre = nombre;
    }
}
