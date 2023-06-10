package com.devlatam.tickets.services;

import org.springframework.stereotype.Service;
import com.devlatam.tickets.repositories.RespuestaRepository;
@Service
public class RespuestaService {

    private final RespuestaRepository respuestaRepository;

    public RespuestaService(RespuestaRepository respuestaRepository){this.respuestaRepository = respuestaRepository;}
}
