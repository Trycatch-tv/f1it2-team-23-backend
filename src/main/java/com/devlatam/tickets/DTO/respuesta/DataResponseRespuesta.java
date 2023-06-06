package com.devlatam.tickets.DTO.respuesta;

import com.devlatam.tickets.DTO.agente.DataResponseAgente;
import com.devlatam.tickets.DTO.ticket.DataResponseTicket;

public record DataResponseRespuesta(
        Long id,
        String titulo,
        String descripcion,
        String fechaCreacion,
        String fechaModificacion,
        Boolean finalizado,
        DataResponseAgente agente,
        Long ticketId
) {
}
