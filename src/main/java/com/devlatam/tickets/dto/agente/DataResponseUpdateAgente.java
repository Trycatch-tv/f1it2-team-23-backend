package com.devlatam.tickets.dto.agente;

public record DataResponseUpdateAgente(
        Long id,
        String nombre,
        String email,
        String telefono
) {
}
