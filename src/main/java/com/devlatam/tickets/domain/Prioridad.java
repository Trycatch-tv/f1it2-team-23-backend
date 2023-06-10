package com.devlatam.tickets.domain;

import com.devlatam.tickets.domain.Ticket;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity(name = "Prioridad")
@Table(name = "prioridad")
@Data
public class Prioridad {
    @Id
    @Column(length = 1,unique = true)
    private Character codigo;
    private String nombre;
    @OneToMany(mappedBy = "prioridad", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ticket> tickets = new HashSet<>();


}
