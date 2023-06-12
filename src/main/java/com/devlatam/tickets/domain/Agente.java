package com.devlatam.tickets.domain;

import com.devlatam.tickets.dto.agente.DataCreacionAgente;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "Agente")
@Table(name = "agente")
@Data
public class Agente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String telefono;
    private String email;
    private Boolean activo;
    @OneToMany(mappedBy = "agente", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ticket> tickets = new HashSet<>();

    public Agente(DataCreacionAgente dataAgente){
        this.nombre = dataAgente.nombre();
        this.telefono = dataAgente.telefono();
        this.email = dataAgente.email();
    }


}
