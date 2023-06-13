package com.devlatam.tickets.controllers;

import com.devlatam.tickets.domain.Agente;
import com.devlatam.tickets.dto.agente.*;
import com.devlatam.tickets.services.AgenteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/agente")
public class AgenteController {

    private final AgenteService agenteService;

    public AgenteController(AgenteService agenteService){this.agenteService = agenteService;}

    @GetMapping
    public Page<DataListAgente> listAgentes(@PageableDefault(size = 20)Pageable pageable){
        return this.agenteService.listAgentes(pageable);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DataResponseAgente> buscarAgente(@PathVariable Long id){
        return ResponseEntity.ok(this.agenteService.buscarAgente(id));
    }
    @PostMapping
    public ResponseEntity<DataCreacionAgente> crearAgente(@RequestBody DataRegistroAgente dataRegistro,
                                                          UriComponentsBuilder uriComponentsBuilder){
        var agente = this.agenteService.crearAgente(dataRegistro);
        URI url = uriComponentsBuilder.path("/agente/{id}").buildAndExpand(agente.id()).toUri();
        return ResponseEntity.created(url).body(agente);
    }
    @PostMapping("/{id}")
    public ResponseEntity<DataResponseUpdateAgente> actualizarAgente(@RequestBody DataUpdateAgente dataUpdate){
        return ResponseEntity.ok(this.agenteService.actualizarAgente(dataUpdate));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarAgente(@PathVariable Long id){
        this.agenteService.eliminarAgente(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
