package com.devlatam.tickets.controllers;

import com.devlatam.tickets.dto.ticket.*;
import com.devlatam.tickets.services.TicketService;
import lombok.RequiredArgsConstructor;
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

    public TicketController(TicketService ticketService){this.ticketService = ticketService;}

    @GetMapping
    Page<DataListTicket> listTickets(@PageableDefault(size=20)Pageable pageable){
        return this.ticketService.listarTickets(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResponseReplyTicket> buscarTicket(@PathVariable Long id){
        return ResponseEntity.ok(this.ticketService.buscarTicket(id));
    }

    @PostMapping
    public ResponseEntity<DataResponseTicket> registrarTicket(@RequestBody DataAsignarTicket dataCreacion,
                                                                    UriComponentsBuilder uriComponentsBuilder){
        var ticket = this.ticketService.asignarTicket(dataCreacion);
        URI url = uriComponentsBuilder.path("/ticket/{id}").buildAndExpand(ticket.id()).toUri();

        return ResponseEntity.created(url).body(ticket);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DataResponseTicket> eliminarTicket(@PathVariable Long id){
        this.ticketService.eliminarTicket(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
