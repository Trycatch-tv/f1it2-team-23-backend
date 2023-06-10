package com.devlatam.tickets.services;

import com.devlatam.tickets.repositories.AgenteRepository;
import org.springframework.stereotype.Service;

@Service
public class AgenteService {

    private final AgenteRepository agenteRepository;

    public AgenteService(AgenteRepository agenteRepository){this.agenteRepository = agenteRepository;}
}
