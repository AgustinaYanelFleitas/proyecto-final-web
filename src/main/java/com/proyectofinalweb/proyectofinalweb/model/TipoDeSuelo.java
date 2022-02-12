package com.proyectofinalweb.proyectofinalweb.model;

import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tipos_suelos")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel(description = "Información de los tipos de suelos")
public class TipoDeSuelo {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    @NotNull(message = "La descripcion no puede ser Nulo")
    @Size(min = 2, message = "La descripcion debe tener al menos dos caracteres")
    private String descripcion;

    @OneToMany
    private List<Cultivo> cultivos;


   }
