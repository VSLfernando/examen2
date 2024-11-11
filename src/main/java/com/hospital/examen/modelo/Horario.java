package com.hospital.examen.modelo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "horario")

public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dia_semana")
    private String diaSemana; // Ejemplo: "Lunes", "Martes", etc.

    @Column(name = "hora_inicio")
    private String horaInicio; // El horario de inicio, puedes usar el tipo 'String' o 'LocalTime' dependiendo del formato que prefieras

    @Column(name = "hora_fin")
    private String horaFin; // El horario de fin, igual que la hora de inicio

    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false) // Llave foránea que se relaciona con la tabla 'medico'
    private Medico medico;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

}
