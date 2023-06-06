package com.devlatam.tickets.repositories;

import com.devlatam.tickets.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRespository extends JpaRepository<Ticket, Long> {
}
