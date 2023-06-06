package com.devlatam.tickets.services;

import com.devlatam.tickets.repositories.RespuestaRepository;

public class RespuestaService {

    private final RespuestaRepository respuestaRepository;

    public RespuestaService(RespuestaRepository respuestaRepository){this.respuestaRepository = respuestaRepository;}
}
