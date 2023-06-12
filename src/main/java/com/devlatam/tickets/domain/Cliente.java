package com.devlatam.tickets.domain;

import com.devlatam.tickets.dto.cliente.DataRegistroCliente;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
@Entity(name = "Cliente")
@Table(name = "cliente")
@NoArgsConstructor
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String telefono;
    private String email;
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ticket> tickets = new HashSet<>();

    public Cliente(DataRegistroCliente dataRegistro){
        this.nombre = dataRegistro.nombre();
        this.email = dataRegistro.email();
        this.telefono = dataRegistro.telefono();

    }

}
