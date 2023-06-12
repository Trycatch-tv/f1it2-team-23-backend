package com.devlatam.tickets.dto.cliente;

public record DataUpdateCliente(
        Long id,
        String nombre,
        String email,
        String telefono
) {
}
