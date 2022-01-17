package com.proyectofinalweb.proyectofinalweb.controller;


import com.proyectofinalweb.proyectofinalweb.dto.EmpleadoDTO;
import com.proyectofinalweb.proyectofinalweb.service.crud.IEmpleadoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping(EmpleadoController.RESOURCE)
public class EmpleadoController {
    private static final Logger logger = LoggerFactory.getLogger(EmpleadoController.class);
    public static final String RESOURCE = "/api/v1/empleados";

    public static final String DNI = "/{empleado_dni}";
    public static final String SEARCH = "/search";

    private IEmpleadoService empleadoService;

    public EmpleadoController(IEmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @RequestMapping(value = DNI, method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<EmpleadoDTO> getOneHotel(@PathVariable("empleado_dni") String empleadoDNI) {
        logger.info("Get Hotel with id {}", empleadoDNI);
        EmpleadoDTO empleado = this.empleadoService.buscarEmpleadoPorDNI(empleadoDNI);
        if (empleado == null) {
            return new ResponseEntity<EmpleadoDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<EmpleadoDTO>(empleado, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET,produces = "application/json")
    public ResponseEntity<Collection<EmpleadoDTO>> getAllHotels(){
        logger.info("Get All Hotels");
        Collection<EmpleadoDTO> hotels = new ArrayList<EmpleadoDTO>();
        hotels.addAll(this.empleadoService.listarTodos());
        if (hotels.isEmpty()){
            return new ResponseEntity<Collection<EmpleadoDTO>>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<Collection<EmpleadoDTO>>(hotels, HttpStatus.OK);
        }
    }
}