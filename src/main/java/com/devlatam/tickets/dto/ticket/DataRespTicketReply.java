package com.devlatam.tickets.dto.ticket;

import com.devlatam.tickets.domain.Ticket;
import com.devlatam.tickets.dto.agente.DataResponseAgente;

public record DataRespTicketReply(
        Long id,
        String titulo,
        String descripcion,
        DataResponseAgente agente) {

}
