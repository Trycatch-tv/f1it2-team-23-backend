package com.devlatam.tickets.dto.respuesta;

import com.devlatam.tickets.dto.ticket.DataListTicket;

public record DataUpdateRespuesta(
        Long id,
        String titulo,
        String descripcion,
        String fechaModificacion,
        Boolean finalizado,
        DataListTicket ticket
) {
}
