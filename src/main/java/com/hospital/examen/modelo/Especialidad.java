package com.hospital.examen.modelo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "especialidad")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    public Especialidad(Medico medico, String descripcion, String nombre) {
        this.medico = medico;
        this.descripcion = descripcion;
        this.nombre = nombre;
    }
}
