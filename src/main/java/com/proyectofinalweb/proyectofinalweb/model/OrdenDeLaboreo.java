package com.proyectofinalweb.proyectofinalweb.model;

import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "ordenes_laboreos")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel(description = "Información de las ordenes de laboreos")
public class OrdenDeLaboreo {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    @NotNull(message = "El numero no puede ser Nulo")
    @Size(min = 2, message = "El numero debe tener al menos dos caracteres")
    private String numero;

    @ManyToOne
    private Laboreo laboreo;



   }
