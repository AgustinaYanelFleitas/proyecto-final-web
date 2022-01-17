package com.proyectofinalweb.proyectofinalweb.model;

import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "empleados")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel(description = "Información de los Empleados")
public class Empleado {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    @NotNull(message = "El nombre no puede ser Nulo")
    @Size(min = 2, message = "El nombre debe tener al menos dos caracteres")
    private String nombre;

    @Column(nullable = false, length = 50)
    @NotNull(message = "El apellido no puede ser Nulo")
    @Size(min = 2, message = "El apellido debe tener al menos dos caracteres")
    private String apellido;

    @Column(nullable = false, length = 50)
    @NotNull(message = "El dni no puede ser Nulo")
    @Size(min = 7, message = "El dni debe tener al menos ocho caracteres")
    private String dni;
}
