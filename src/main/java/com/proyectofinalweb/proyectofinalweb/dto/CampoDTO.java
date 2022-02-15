package com.proyectofinalweb.proyectofinalweb.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.proyectofinalweb.proyectofinalweb.model.EstadoDeCampo;
import com.proyectofinalweb.proyectofinalweb.model.Lote;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Validated
@Data
public class CampoDTO {

    @JsonIgnore
    private Integer id;

    @NotNull(message = "El numeroCampo no puede ser Nulo")
    @Size(min = 2, message = "El numeroCampo debe tener al menos dos caracteres")
    private String numeroCampo;

    @ManyToOne
    private EstadoDeCampo estadoDeCampo;

    @OneToMany(mappedBy = "campo", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REMOVE }, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Lote> lotes;

}
