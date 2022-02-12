package com.proyectofinalweb.proyectofinalweb.service.crud.impl;


import com.proyectofinalweb.proyectofinalweb.dto.EmpleadoDTO;
import com.proyectofinalweb.proyectofinalweb.model.Empleado;
import com.proyectofinalweb.proyectofinalweb.repository.EmpleadoRepository;
import com.proyectofinalweb.proyectofinalweb.service.crud.IEmpleadoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

    private EmpleadoRepository empleadoRepository;

    private ModelMapper modelMapper;

    public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository, ModelMapper modelMapper) {
        this.empleadoRepository = empleadoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public EmpleadoDTO registrar(EmpleadoDTO empleadoDTO)  {

        Empleado nuevoEmpleado = modelMapper.map(empleadoDTO, Empleado.class);
        empleadoRepository.save(nuevoEmpleado);
        empleadoDTO.setId(nuevoEmpleado.getId());
        return empleadoDTO;
    }

    @Override
    @Transactional
    public EmpleadoDTO modificar(EmpleadoDTO empleadoDTO) {
        Empleado nuevoEmpleado = modelMapper.map(empleadoDTO, Empleado.class);
        empleadoRepository.save(nuevoEmpleado);
        return empleadoDTO;
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        Optional<Empleado> opt = empleadoRepository.findById(id);
        if (!opt.isPresent()) {
            throw new NoSuchElementException("No existe empleado con el id: " + id);
        }
        empleadoRepository.deleteById(id);
    }

    @Override
    public EmpleadoDTO listarId(Integer id) {
        Optional<Empleado> opt = empleadoRepository.findById(id);

        if (!opt.isPresent()) {
            throw new NoSuchElementException("No existe empleado con el id: " + id);
        }
        return modelMapper.map(opt.get(), EmpleadoDTO.class);
    }

    @Override
    public List<EmpleadoDTO> listarTodos() {
        List<EmpleadoDTO> empleadosDTO = empleadoRepository.findAll()
                .stream()
                .map(empleado -> modelMapper.map(empleado, EmpleadoDTO.class))
                .collect(Collectors.toList());
        return empleadosDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public EmpleadoDTO buscarEmpleadoPorDNI(String dni) {
        Empleado empleado = empleadoRepository.findByDni(dni);
        if(empleado == null) {
           return  null;
        }
        return modelMapper.map(empleado, EmpleadoDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public EmpleadoDTO findById(int empleado_id) {
        Empleado empleado = empleadoRepository.findById(empleado_id);
        if(empleado == null) {
            throw new NoSuchElementException("nonexistent id: " + empleado_id);
        }
        return modelMapper.map(empleado, EmpleadoDTO.class);

    }

    @Override
    @Transactional(readOnly = true)
    public EmpleadoDTO modificarEmpleado(EmpleadoDTO empleadoDTO) {
        Empleado nuevoEmpleado = modelMapper.map(empleadoDTO, Empleado.class);
        empleadoRepository.save(nuevoEmpleado);
        return empleadoDTO;
    }

}
