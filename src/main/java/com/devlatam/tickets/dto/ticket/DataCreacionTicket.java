package com.devlatam.tickets.dto.ticket;

public record DataCreacionTicket(
        String titulo,
        String descripcion,
        Long clienteId,
        Character prioridadId,
        Character estadoId
) {
}
