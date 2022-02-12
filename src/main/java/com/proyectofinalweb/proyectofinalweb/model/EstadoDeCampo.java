package com.proyectofinalweb.proyectofinalweb.model;

import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "estado_campos")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel(description = "Información de los estados de campos")
public class EstadoDeCampo {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    @NotNull(message = "La descrpcion no puede ser Nula")
    @Size(min = 2, message = "La descripcion debe tener al menos dos caracteres")
    private String descripcion;



   }
