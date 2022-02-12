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
@Table(name = "campos")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel(description = "Información de los campos")
public class Campo {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    @NotNull(message = "El numeroCampo no puede ser Nulo")
    @Size(min = 2, message = "El numeroCampo debe tener al menos dos caracteres")
    private String numeroCampo;

    @ManyToOne
    private EstadoDeCampo estadoDeCampo;

    @OneToMany(mappedBy = "campo", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REMOVE }, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Lote> lotes;



   }
