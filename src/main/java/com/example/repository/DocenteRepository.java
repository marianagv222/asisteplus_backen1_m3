package com.example.repository;

import com.example.Docente;
import com.example.repository.impl.GenericRepositoryImpl;
import jakarta.persistence.EntityManager;

public class DocenteRepository extends GenericRepositoryImpl<Docente, Long> {
    public DocenteRepository(EntityManager em) {
        super(em, Docente.class);
    }
}
