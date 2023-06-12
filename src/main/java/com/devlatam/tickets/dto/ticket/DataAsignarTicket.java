package com.devlatam.tickets.dto.ticket;

import java.util.Optional;

public record DataAsignarTicket(
        Long id,
        String titulo,
        String descripcion,
        Optional<Long> agenteId,
        Optional<Long> estadoId,
        Optional<Long> prioridadId,
        Optional<Long> categoriaId
) {
}
