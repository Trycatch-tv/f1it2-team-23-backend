package com.devlatam.tickets.DTO.ticket;

import com.devlatam.tickets.DTO.agente.DataResponseAgente;
import com.devlatam.tickets.DTO.cliente.DataResponseCliente;

public record DataResponseTicket(
        Long id,
        String titulo,
        String descripcion,
        String fechaCreacion,
        DataResponseCliente cliente,
        DataResponseAgente agente



) {
}
