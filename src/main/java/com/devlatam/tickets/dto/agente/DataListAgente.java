package com.devlatam.tickets.dto.agente;

import com.devlatam.tickets.domain.Agente;

public record DataListAgente(Long id, String nombre, String email) {
    public DataListAgente(Agente agente){this(agente.getId(), agente.getNombre(), agente.getEmail());}
}
