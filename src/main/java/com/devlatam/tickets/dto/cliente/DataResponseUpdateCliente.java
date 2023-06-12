package com.devlatam.tickets.dto.cliente;

public record DataResponseUpdateCliente(
        Long id,
        String nombre,
        String email,
        String telefono
) {
}
