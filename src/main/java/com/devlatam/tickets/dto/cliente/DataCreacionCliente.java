package com.devlatam.tickets.dto.cliente;

public record DataCreacionCliente(
        Long id,
        String nombre,
        String telefono,
        String email
) {
}
