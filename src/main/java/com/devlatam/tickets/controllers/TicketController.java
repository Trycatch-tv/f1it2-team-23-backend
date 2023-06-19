package com.devlatam.tickets.controllers;

import com.devlatam.tickets.domain.Agente;
import com.devlatam.tickets.domain.Categoria;
import com.devlatam.tickets.domain.Estado;
import com.devlatam.tickets.domain.Prioridad;
import com.devlatam.tickets.dto.ticket.*;
import com.devlatam.tickets.services.TicketService;
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
@RequestMapping("/api/ticket")
public class TicketController {
    private final TicketService ticketService;
    @Autowired
    public TicketController(TicketService ticketService){this.ticketService = ticketService;}

    @GetMapping
    public Page<DataListTicket> listTickets(@PageableDefault(size=20)Pageable pageable){
        return ticketService.listarTickets(pageable);
    }

    @PostMapping
    public ResponseEntity<DataResponseCreateTicket> registrarTicket(@RequestBody DataCreacionTicket dataCreacion,
                                                                    UriComponentsBuilder uriComponentsBuilder){
        var ticket = ticketService.crearTicket(dataCreacion);
        URI url = uriComponentsBuilder.path("/ticket/{id}").buildAndExpand(ticket.id()).toUri();
        return ResponseEntity.created(url).body(ticket);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResponseReplyTicket> buscarTicket(@PathVariable Long id){
        return ResponseEntity.ok(ticketService.buscarTicket(id));
    }

    @PostMapping
    public ResponseEntity<DataResponseTicket> asignarTicket(@RequestBody DataAsignarTicket dataAsignar,
                          Agente agente, Categoria categoria, Estado estado, Prioridad prioridad,
                           UriComponentsBuilder uriComponentsBuilder){
        var ticket = ticketService.asignarTicket(dataAsignar,agente,categoria,estado,prioridad);
        URI url = uriComponentsBuilder.path("/ticket/{id}").buildAndExpand(ticket.id()).toUri();

        return ResponseEntity.created(url).body(ticket);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DataResponseTicket> eliminarTicket(@PathVariable Long id){
        ticketService.eliminarTicket(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
