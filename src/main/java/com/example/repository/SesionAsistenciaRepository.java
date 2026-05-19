package com.example.repository;

import com.example.SesionAsistencia;
import com.example.repository.impl.GenericRepositoryImpl;
import jakarta.persistence.EntityManager;

public class SesionAsistenciaRepository extends GenericRepositoryImpl<SesionAsistencia, Long> {
    public SesionAsistenciaRepository(EntityManager em) {
        super(em, SesionAsistencia.class);
    }
}
