package com.hospital.examen.modelo;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "medico", uniqueConstraints = @UniqueConstraint(columnNames = "email"))

public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    private String email;
    private String telefono;
    private String nro_matricula;
    private String password;

    @OneToMany(mappedBy = "medico")

    private List<Especialidad> especialidades = new ArrayList<>();

    public Medico(String nombre, String apellido, String email, String telefono, String nro_matricula, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.nro_matricula = nro_matricula;
        this.password = password;
    }

    public Medico(String nombre, String apellido, String email, String telefono, String nro_matricula, String password, List<Especialidad> especialidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.nro_matricula = nro_matricula;
        this.password = password;
        this.especialidades = especialidades;
    }
}
