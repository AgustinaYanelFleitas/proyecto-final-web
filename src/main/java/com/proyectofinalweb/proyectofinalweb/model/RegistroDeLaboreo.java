package com.proyectofinalweb.proyectofinalweb.model;

import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "registros_laboreos")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel(description = "Información de los registros de laboreos")
public class RegistroDeLaboreo {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_proyecto_de_cultivo_fk")
    private ProyectoDeCultivo proyectoDeCultivo;

    @Column(nullable = false, length = 50)
    @NotNull(message = "El numeroCampo no puede ser Nulo")
    @Size(min = 2, message = "El numeroCampo debe tener al menos dos caracteres")
    private String numeroCampo;

    @Column(columnDefinition = "DATE")
    private LocalDate inicioRegistro;

    @Column(columnDefinition = "DATE")
    private LocalDate finalizacionRegistro;

    @OneToMany
    private List<Laboreo> laboreos;



   }
