package com.hospital.examen.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "especialidad")
@AllArgsConstructor
@NoArgsConstructor

public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToMany
    @JoinTable(
            name = "especialidad_medico",
            joinColumns = @JoinColumn(name = "especialidad_id"),
            inverseJoinColumns = @JoinColumn(name = "medico_id")
    )
    private List<Medico> medicos; // Médicos asociados a esta especialidad

//    public Especialidad(Medico medico, String descripcion, String nombre) {
//        this.medico = medico;
//        this.descripcion = descripcion;
//        this.nombre = nombre;
//    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }

    public Especialidad(String nombre, String descripcion, List<Medico> medicos) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.medicos = medicos;
    }
}
