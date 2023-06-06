package com.devlatam.tickets.utils;

import com.devlatam.tickets.domain.Ticket;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Entity(name = "Categoria")
@Table(name = "categoria")
@Data
public class Categoria {
    @Id
    @Column(length = 1,unique = true)
    private Character codigo;
    private String nombre;
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ticket> tickets = new HashSet<>();


}
