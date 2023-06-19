package com.devlatam.tickets.dto.ticket;

import com.devlatam.tickets.domain.Ticket;
import com.devlatam.tickets.dto.agente.DataResponseAgente;

public record DataResponseTicketAgente(
        Long id,
        DataResponseAgente agente
) {
    public DataResponseTicketAgente(Ticket ticket){
        this(ticket.getId(), new DataResponseAgente(ticket.getAgente().getId(), ticket.getAgente().getNombre(),
                        ticket.getAgente().getEmail()));
    }



}
