package com.devlatam.tickets.services;

import com.devlatam.tickets.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){ this.clienteRepository = clienteRepository;}
}
