package com.devlatam.tickets.domain;

import com.devlatam.tickets.dto.respuesta.DataCreacionRespuesta;
import com.devlatam.tickets.dto.ticket.DataResponseTicket;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "Respuesta")
@Table(name = "respuesta")
@Getter
@Setter
@NoArgsConstructor
@Data
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descripcion;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;
    private Boolean finalizado;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    public Respuesta(DataCreacionRespuesta dataCreacion, Ticket ticket){
        this.id = dataCreacion.id();
        this.titulo = dataCreacion.titulo();
        this.descripcion = dataCreacion.descripcion();
        this.fechaCreacion = LocalDateTime.now();
        this.finalizado = dataCreacion.finalizado();
        this.ticket = ticket;



    }


}
