package com.devlatam.tickets.controllers;

import com.devlatam.tickets.services.TicketService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService){this.ticketService = ticketService;}


}
