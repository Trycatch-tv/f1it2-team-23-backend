package com.devlatam.tickets.dto.ticket;

public record DataAsignarTicket(
        Long id,
        String titulo,
        String descripcion,
        Long agenteId,
        Long estadoId,
        Long prioridadId
) {
}
