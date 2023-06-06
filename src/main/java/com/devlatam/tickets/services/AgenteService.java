package com.devlatam.tickets.services;

import com.devlatam.tickets.repositories.AgenteRepository;

public class AgenteService {

    private final AgenteRepository agenteRepository;

    public AgenteService(AgenteRepository agenteRepository){this.agenteRepository = agenteRepository;}
}
