package com.devlatam.tickets.DTO.ticket;

public record DataCreacionTicket(
        String titulo,
        String descripcion,
        Long clienteId,
        Long prioridadId
) {
}
