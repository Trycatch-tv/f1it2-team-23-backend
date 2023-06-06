package com.devlatam.tickets.DTO.ticket;

public record DataAsignarTicket(
        Long id,
        String titulo,
        String descripcion,
        Long agenteId,
        Long estadoId,
        Long prioridadId
) {
}
