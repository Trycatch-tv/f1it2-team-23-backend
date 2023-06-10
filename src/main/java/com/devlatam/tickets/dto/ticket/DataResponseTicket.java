package com.devlatam.tickets.dto.ticket;

import com.devlatam.tickets.dto.cliente.DataResponseCliente;
import com.devlatam.tickets.dto.estado.DataResponseEstado;
import com.devlatam.tickets.dto.prioridad.DataResponsePrioridad;

public record DataResponseTicket(
        Long id,
        String titulo,
        String descripcion,
        String fechaCreacion,
        DataResponseEstado estado,
        DataResponsePrioridad prioridad,
        DataResponseCliente cliente

) {
}
