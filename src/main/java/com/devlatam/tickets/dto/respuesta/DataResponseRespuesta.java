package com.devlatam.tickets.dto.respuesta;

import com.devlatam.tickets.dto.agente.DataResponseAgente;

public record DataResponseRespuesta(
        Long id,
        String titulo,
        String descripcion,
        String fechaCreacion,
        String fechaModificacion,
        Boolean finalizado,
        DataResponseAgente agente,
        Long ticketId
) {
}
