package com.devlatam.tickets.dto.ticket;

import com.devlatam.tickets.dto.agente.DataResponseAgente;
import com.devlatam.tickets.dto.cliente.DataResponseCliente;

public record DataUpdateTicket(
        Long id,
        String titulo,
        String descripcion,
        String fechaCreacion,
        DataResponseCliente cliente,
        DataResponseAgente agente
) {
}
