package com.devlatam.tickets.services;

import com.devlatam.tickets.dto.cliente.DataResponseCliente;
import com.devlatam.tickets.dto.estado.DataResponseEstado;
import com.devlatam.tickets.dto.prioridad.DataResponsePrioridad;
import com.devlatam.tickets.dto.ticket.DataCreacionTicket;
import com.devlatam.tickets.dto.ticket.DataResponseTicket;
import com.devlatam.tickets.dto.ticket.DataResponseUpdateTicket;
import com.devlatam.tickets.domain.Cliente;
import com.devlatam.tickets.domain.Ticket;
import com.devlatam.tickets.repositories.ClienteRepository;
import com.devlatam.tickets.repositories.EstadoRepository;
import com.devlatam.tickets.repositories.PrioridadRepository;
import com.devlatam.tickets.repositories.TicketRespository;
import com.devlatam.tickets.domain.Estado;
import com.devlatam.tickets.domain.Prioridad;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    private final TicketRespository ticketRespository;
    private final ClienteRepository clienteRepository;
    private final PrioridadRepository prioridadRepository;
    private final EstadoRepository estadoRepository;

    public TicketService(TicketRespository ticketRespository, ClienteRepository clienteRepository,
                         PrioridadRepository prioridadRepository, EstadoRepository estadoRepository){
        this.ticketRespository = ticketRespository;
        this.clienteRepository = clienteRepository;
        this.prioridadRepository = prioridadRepository;
        this.estadoRepository = estadoRepository;
    }

    public DataResponseTicket creacionTicket(DataCreacionTicket dataCreacion){
        Cliente cliente = this.clienteRepository.getReferenceById(dataCreacion.clienteId());
        Prioridad prioridad = this.prioridadRepository.getReferenceById(dataCreacion.prioridadId());
        Estado estado = this.estadoRepository.getReferenceById(dataCreacion.estadoId());
        Ticket ticket = this.ticketRespository.save(new Ticket(dataCreacion, cliente, prioridad, estado));

        return buildDataResponseTicket(ticket);
    }

    private DataResponseTicket buildDataResponseTicket(Ticket ticket) {
        return new DataResponseTicket(ticket.getId(), ticket.getTitulo(), ticket.getDescripcion(),
                ticket.getFechaCreacion().toString(), buildDataResponseEstado(ticket),
                buildDataResponsePrioridad(ticket), builDataResponseCliente(ticket) );
    }

    private DataResponseCliente builDataResponseCliente(Ticket ticket){
        return new DataResponseCliente(ticket.getCliente().getId(),ticket.getCliente().getNombre(),
                ticket.getCliente().getEmail());
    }
    private DataResponseEstado buildDataResponseEstado(Ticket ticket){
        return new DataResponseEstado(ticket.getEstado().getCodigo(), ticket.getEstado().getNombre());
    }

    private DataResponsePrioridad buildDataResponsePrioridad(Ticket ticket){
        return new DataResponsePrioridad(ticket.getPrioridad().getCodigo(), ticket.getPrioridad().getNombre());
    }

}
