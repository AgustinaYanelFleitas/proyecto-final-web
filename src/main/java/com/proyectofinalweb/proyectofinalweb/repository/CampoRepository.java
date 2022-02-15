package com.proyectofinalweb.proyectofinalweb.repository;

import com.proyectofinalweb.proyectofinalweb.model.Campo;
import com.proyectofinalweb.proyectofinalweb.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampoRepository extends JpaRepository<Campo, Integer> {
    Campo findById(int id);
}
