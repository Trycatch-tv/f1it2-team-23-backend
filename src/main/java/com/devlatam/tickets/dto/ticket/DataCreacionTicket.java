package com.devlatam.tickets.dto.ticket;

import com.devlatam.tickets.dto.cliente.DataResponseCliente;
import com.devlatam.tickets.dto.estado.DataResponseEstado;
import com.devlatam.tickets.dto.prioridad.DataResponsePrioridad;

public record DataCreacionTicket(
        String titulo,
        String descripcion,
        Long clienteId,
        Character prioridadId,
        Character estadoId
) {
}
