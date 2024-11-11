package com.hospital.examen.modelo;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
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

    @ManyToMany(mappedBy = "medicos") // Relación bidireccional
    private List<Especialidad> especialidades;

    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Horario> horarios = new ArrayList<>();

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNro_matricula() {
        return nro_matricula;
    }

    public void setNro_matricula(String nro_matricula) {
        this.nro_matricula = nro_matricula;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Especialidad> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<Especialidad> especialidades) {
        this.especialidades = especialidades;
    }

    public void addHorario(Horario horario) {
        this.horarios.add(horario);
        horario.setMedico(this); // Asegura que la relación bidireccional se mantenga
    }

    public void removeHorario(Horario horario) {
        this.horarios.remove(horario);
        horario.setMedico(null); // Asegura que la relación bidireccional se mantenga
    }


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

    @Override
    public String toString() {
        return this.nombre;  // Devolver el nombre del médico en lugar de la referencia de memoria
    }
}
