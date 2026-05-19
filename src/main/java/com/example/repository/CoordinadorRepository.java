package com.example.repository;

import com.example.Coordinador;
import com.example.repository.impl.GenericRepositoryImpl;
import jakarta.persistence.EntityManager;

public class CoordinadorRepository extends GenericRepositoryImpl<Coordinador, Long> {
    public CoordinadorRepository(EntityManager em) {
        super(em, Coordinador.class);
    }
}
