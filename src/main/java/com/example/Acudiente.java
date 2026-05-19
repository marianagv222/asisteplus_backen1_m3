package com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "acudientes")
public class Acudiente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String telefono;
    private String parentesco;
    private String email;

    public Acudiente() {
    }

    public Acudiente(String name, String telefono, String parentesco) {
        this.name = name;
        this.telefono = telefono;
        this.parentesco = parentesco;
    }

    public Acudiente(String name, String telefono, String parentesco, String email) {
        this.name = name;
        this.telefono = telefono;
        this.parentesco = parentesco;
        this.email = email;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Acudiente [id=" + id + ", name=" + name + ", telefono=" + telefono + ", parentesco=" + parentesco + ", email=" + email + "]";
    }
}
