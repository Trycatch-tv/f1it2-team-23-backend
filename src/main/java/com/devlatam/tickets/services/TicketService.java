package com.devlatam.tickets.services;

import com.devlatam.tickets.repositories.TicketRespository;

public class TicketService {

    private final TicketRespository ticketRespository;

    public TicketService(TicketRespository ticketRespository){this.ticketRespository = ticketRespository;}


}
