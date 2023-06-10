package com.devlatam.tickets.repositories;

import com.devlatam.tickets.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRespository extends JpaRepository<Ticket, Long> {
}
