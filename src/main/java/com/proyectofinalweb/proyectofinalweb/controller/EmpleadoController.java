package com.proyectofinalweb.proyectofinalweb.controller;


import com.proyectofinalweb.proyectofinalweb.dto.EmpleadoDTO;
import com.proyectofinalweb.proyectofinalweb.service.crud.IEmpleadoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
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
    public ResponseEntity<EmpleadoDTO> getOneEmpleado(@PathVariable("empleado_dni") String empleadoDNI) {
        logger.info("Buscar un empleado por dni {}", empleadoDNI);
        EmpleadoDTO empleado = this.empleadoService.buscarEmpleadoPorDNI(empleadoDNI);
        if (empleado == null) {
            return new ResponseEntity<EmpleadoDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<EmpleadoDTO>(empleado, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET,produces = "application/json")
    public ResponseEntity<Collection<EmpleadoDTO>> getEmpleados(){
        logger.info("Get All Hotels");
        Collection<EmpleadoDTO> empleados = new ArrayList<EmpleadoDTO>();
        empleados.addAll(this.empleadoService.listarTodos());
        if (empleados.isEmpty()){
            return new ResponseEntity<Collection<EmpleadoDTO>>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<Collection<EmpleadoDTO>>(empleados, HttpStatus.OK);
        }
    }


    @RequestMapping(method = RequestMethod.POST, consumes="application/json")
    @ResponseBody
    public ResponseEntity<EmpleadoDTO> create(@RequestBody EmpleadoDTO nuevoEmpleado) {
        EmpleadoDTO eempleadoRespuesta = null;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Responded", "EmpleadoController");

        try {
            if (empleadoService.buscarEmpleadoPorDNI(nuevoEmpleado.getDni())==null){
                eempleadoRespuesta = empleadoService.registrar(nuevoEmpleado);
            }

        } catch(Exception ex) {
            System.out.println("Employee not found" + ex.getMessage());
            return ResponseEntity.ok().headers(headers).body(eempleadoRespuesta);
        }

        return ResponseEntity.ok().headers(headers).body(eempleadoRespuesta);
    }

}