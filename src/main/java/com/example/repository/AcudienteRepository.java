package com.example.repository;

import com.example.Acudiente;
import com.example.repository.impl.GenericRepositoryImpl;
import jakarta.persistence.EntityManager;

public class AcudienteRepository extends GenericRepositoryImpl<Acudiente, Long> {
    public AcudienteRepository(EntityManager em) {
        super(em, Acudiente.class);
    }
}
