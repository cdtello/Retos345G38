package com.example.testG38.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.testG38.entities.Estudiante;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer>{
    
}
