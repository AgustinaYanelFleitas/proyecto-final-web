package com.proyectofinalweb.proyectofinalweb.service.crud;


import com.proyectofinalweb.proyectofinalweb.dto.EmpleadoDTO;
import com.proyectofinalweb.proyectofinalweb.service.crud.ICRUD;

public interface ICampoSerivece extends ICRUD<EmpleadoDTO> {

    EmpleadoDTO buscarEmpleadoPorDNI(String dni);

    EmpleadoDTO findById(int empleado_id);

    EmpleadoDTO modificarEmpleado(EmpleadoDTO empleadoDTO);
}
