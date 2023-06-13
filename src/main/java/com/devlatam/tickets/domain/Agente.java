package com.devlatam.tickets.domain;

import com.devlatam.tickets.dto.agente.DataRegistroAgente;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "Agente")
@Table(name = "agente")
@NoArgsConstructor
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

    public Agente(DataRegistroAgente dataAgente){
        this.nombre = dataAgente.nombre();
        this.email = dataAgente.email();
        this.telefono = dataAgente.telefono();
    }


}
