package com.proyectofinalweb.proyectofinalweb.repository;


import com.proyectofinalweb.proyectofinalweb.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

    Empleado findByDni(String dni);
    Empleado findById(int id);

}
