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
@Table(name = "cultivos")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel(description = "Información de los cultivos")
public class Cultivo {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    @NotNull(message = "El descripcion no puede ser Nulo")
    @Size(min = 2, message = "El descripcion debe tener al menos dos caracteres")
    private String descripcion;

    @OneToMany
    private List<OrdenDeLaboreo> ordenDeLaboreos;

   }
