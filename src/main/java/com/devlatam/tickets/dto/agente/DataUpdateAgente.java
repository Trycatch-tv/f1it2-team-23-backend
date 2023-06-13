package com.devlatam.tickets.dto.agente;

public record DataUpdateAgente(
        Long id,
        String nombre,
        String email,
        String telefono
) {
}
