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
@Table(name = "proyectos_cultivos")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel(description = "Información de los proyectos de cultivos")
public class ProyectoDeCultivo {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_lote_fk")
    private Lote lote;

    @Column(nullable = false, length = 50)
    @NotNull(message = "El numeroProyecto no puede ser Nulo")
    @Size(min = 2, message = "El numeroProyecto debe tener al menos dos caracteres")
    private String numeroProyecto;

    @ManyToOne
    private Cultivo cultivo;

    @ManyToOne
    private EstadoDeProyecto estadoDeProyecto;

    @OneToMany(mappedBy = "proyectoDeCultivo", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REMOVE }, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<RegistroDeLaboreo> registroDeLaboreos;


   }
