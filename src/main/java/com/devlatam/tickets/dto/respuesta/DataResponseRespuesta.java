package com.devlatam.tickets.dto.respuesta;

import com.devlatam.tickets.dto.ticket.DataRespTicketReply;

public record DataResponseRespuesta(
        Long id,
        String titulo,
        String descripcion,
        String fechaCreacion,
        String fechaModificacion,
        Boolean finalizado,

        DataRespTicketReply dataRespTicketReply) {
}
