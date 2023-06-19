package com.devlatam.tickets.dto.respuesta;

import com.devlatam.tickets.dto.ticket.DataResponseTicket;

public record DataResponseCreateReply(
        Long id,
        String titulo,
        String descripcion,
        String fechaCreacion,
        DataResponseTicket ticket
) {
}
