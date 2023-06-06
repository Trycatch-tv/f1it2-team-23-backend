package com.devlatam.tickets.utils;

import com.devlatam.tickets.domain.Ticket;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Entity(name = "Estado")
@Table(name = "estado")
@Data
public class Estado {
    @Id
    @Column(length = 1,unique = true)
    private Character codigo;
    private String nombre;
    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ticket> tickets = new HashSet<>();


}
