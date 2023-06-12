package com.devlatam.tickets.dto.cliente;

import com.devlatam.tickets.domain.Cliente;

public record DataListCliente(Long id, String nombre, String email) {

    public DataListCliente(Cliente cliente){ this(cliente.getId(), cliente.getNombre(), cliente.getEmail());}
}
