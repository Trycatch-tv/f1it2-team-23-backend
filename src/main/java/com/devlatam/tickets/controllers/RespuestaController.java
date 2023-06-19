package com.devlatam.tickets.controllers;

import com.devlatam.tickets.dto.respuesta.*;
import com.devlatam.tickets.services.RespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/respuesta")
public class RespuestaController {

    private final RespuestaService respuestaService;

    @Autowired
    public RespuestaController(RespuestaService respuestaService){this.respuestaService = respuestaService;}

    @GetMapping
    public Page<DataListReplyTicket> listarRespuestas(@PageableDefault(size = 20) Pageable pageable){
        return respuestaService.listarRespuestas(pageable);
    }
    @PostMapping
    public ResponseEntity<DataResponseCreateReply> registrarRespuesta(@RequestBody DataCreacionRespuesta dataCreacion,
                                                                      UriComponentsBuilder uriComponentsBuilder){
        var respuesta = respuestaService.crearRespuesta(dataCreacion);
        URI url = uriComponentsBuilder.path("/respuesta/{id}").buildAndExpand(respuesta.id()).toUri();
        return ResponseEntity.created(url).body(respuesta);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DataResponseRespuesta> buscarRespuesta(@PathVariable Long id){
        return ResponseEntity.ok(respuestaService.buscarRespuesta(id));
    }
    @PostMapping
    public ResponseEntity<DataResponseRespuesta> actualizarRespuesta(@RequestBody DataUpdateRespuesta dataUpdate,
                                                                     UriComponentsBuilder uriComponentsBuilder){
        var respuesta = respuestaService.actualizarRespuesta(dataUpdate);
        URI url = uriComponentsBuilder.path("/respuesta/{id}").buildAndExpand(respuesta.id()).toUri();
        return ResponseEntity.created(url).body(respuesta);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<DataResponseRespuesta> eliminarRespuesta(@PathVariable Long id){
        respuestaService.eliminarRespuesta(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
