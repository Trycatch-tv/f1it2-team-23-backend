package com.devlatam.tickets.domain;

import com.devlatam.tickets.dto.agente.DataResponseAgente;
import com.devlatam.tickets.dto.categoria.DataResponseCategoria;
import com.devlatam.tickets.dto.cliente.DataResponseCliente;
import com.devlatam.tickets.dto.estado.DataResponseEstado;
import com.devlatam.tickets.dto.prioridad.DataResponsePrioridad;
import com.devlatam.tickets.dto.ticket.DataAsignarTicket;
import com.devlatam.tickets.dto.ticket.DataCreacionTicket;
import com.devlatam.tickets.dto.ticket.DataResponseTicket;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Ticket")
@Table(name = "ticket")
@NoArgsConstructor
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
                  Prioridad prioridad){
        this.titulo = dataCreacion.titulo();
        this.descripcion = dataCreacion.descripcion();
        this.fechaCreacion = LocalDateTime.now();
        this.cliente = cliente;
        this.prioridad = prioridad;
        this.estado = estado;
    }

    public Ticket(DataAsignarTicket dataAsignar, Agente agente, Categoria categoria, Estado estado, Prioridad prioridad){
        this.titulo = dataAsignar.titulo();
        this.descripcion = dataAsignar.descripcion();
        this.agente = agente;
        this.prioridad = prioridad;
        this.estado = estado;
        this.categoria = categoria;
    }





}
