package com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "sesiones_asistencia")
public class SesionAsistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "docente_id")
    private Docente docente;

    private String observaciones;

    public SesionAsistencia() {
    }

    public SesionAsistencia(LocalDate fecha, Curso curso, Docente docente, String observaciones) {
        this.fecha = fecha;
        this.curso = curso;
        this.docente = docente;
        this.observaciones = observaciones;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return "SesionAsistencia{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", curso=" + (curso != null ? curso.getName() : "null") +
                ", docente=" + (docente != null ? docente.getName() : "null") +
                ", observaciones='" + observaciones + '\'' +
                '}';
    }
}
