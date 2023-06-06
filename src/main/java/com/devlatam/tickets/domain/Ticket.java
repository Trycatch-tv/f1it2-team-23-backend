package com.devlatam.tickets.domain;

import com.devlatam.tickets.DTO.ticket.DataAsignarTicket;
import com.devlatam.tickets.DTO.ticket.DataCreacionTicket;
import com.devlatam.tickets.utils.Categoria;
import com.devlatam.tickets.utils.Estado;
import com.devlatam.tickets.utils.Prioridad;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;
import com.devlatam.tickets.domain.Cliente;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "Ticket")
@Table(name = "ticket")
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descripcion;
    private LocalDateTime fechaCreacion;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Respuesta> respuestas = new HashSet<>();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agente_id")
    private Agente agente;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado_id")
    private Estado estado;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prioridad_id")
    private Prioridad prioridad;

// Constructor para que el usuario cree el ticket
    public Ticket(DataCreacionTicket dataCreacion, Cliente cliente, Estado estado,
                  Categoria categoria, Prioridad prioridad){
        this.titulo = dataCreacion.titulo();
        this.descripcion = dataCreacion.descripcion();
        this.fechaCreacion = LocalDateTime.now();
        this.cliente = cliente;
        this.categoria = categoria;
        this.prioridad = prioridad;
        this.estado = estado;
    }

    public void asignarTicket(DataAsignarTicket dataAsignar){
    }


}
