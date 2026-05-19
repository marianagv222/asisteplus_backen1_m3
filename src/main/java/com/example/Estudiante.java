package com.example;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "estudiantes")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDate fechaNacimiento;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "acudiente_id")
    private Acudiente acudiente;

    public Estudiante() {
    }

    public Estudiante(String name, LocalDate fechaNacimiento, Curso curso, Acudiente acudiente) {
        this.name = name;
        this.fechaNacimiento = fechaNacimiento;
        this.curso = curso;
        this.acudiente = acudiente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Acudiente getAcudiente() {
        return acudiente;
    }

    public void setAcudiente(Acudiente acudiente) {
        this.acudiente = acudiente;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", curso=" + (curso != null ? curso.getName() : "null") +
                ", acudiente=" + (acudiente != null ? acudiente.getName() : "null") +
                '}';
    }
}
