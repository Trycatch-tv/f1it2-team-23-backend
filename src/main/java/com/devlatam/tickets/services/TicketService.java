package com.devlatam.tickets.services;

import com.devlatam.tickets.dto.agente.DataResponseAgente;
import com.devlatam.tickets.dto.categoria.DataResponseCategoria;
import com.devlatam.tickets.dto.cliente.DataResponseCliente;
import com.devlatam.tickets.dto.estado.DataResponseEstado;
import com.devlatam.tickets.dto.prioridad.DataResponsePrioridad;
import com.devlatam.tickets.dto.respuesta.DataListReplyTicket;
import com.devlatam.tickets.dto.ticket.*;
import com.devlatam.tickets.domain.Cliente;
import com.devlatam.tickets.domain.Ticket;
import com.devlatam.tickets.repositories.ClienteRepository;
import com.devlatam.tickets.repositories.EstadoRepository;
import com.devlatam.tickets.repositories.PrioridadRepository;
import com.devlatam.tickets.repositories.TicketRespository;
import com.devlatam.tickets.domain.Estado;
import com.devlatam.tickets.domain.Prioridad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public DataResponseCreateTicket creacionTicket(DataCreacionTicket dataCreacion){
        Cliente cliente = this.clienteRepository.getReferenceById(dataCreacion.clienteId());
        Prioridad prioridad = this.prioridadRepository.getReferenceById(dataCreacion.prioridadId());
        Estado estado = this.estadoRepository.getReferenceById(dataCreacion.estadoId());
        Ticket ticket = this.ticketRespository.save(new Ticket(dataCreacion, cliente, prioridad, estado));

        return buildDataResponseCreateTicket(ticket);
    }

    public DataResponseReplyTicket buscarTicket(Long id){
        Ticket ticket = this.ticketRespository.getReferenceById(id);
        DataResponseTicket dataResponse = buildDataResponseTicket(ticket);

        return new DataResponseReplyTicket(dataResponse.id(), dataResponse.titulo(), dataResponse.descripcion(),
                dataResponse.fechaCreacion(), dataResponse.categoria(), dataResponse.estado(), dataResponse.prioridad(),
                dataResponse.cliente(), dataResponse.agente(), buildDataListReplyTicket(ticket));


    }
    public Page<DataListTicket> listarTickets(Pageable pageable){
        Page<Ticket> tickets = this.ticketRespository.findAll(pageable);
        return tickets.map(DataListTicket::new);
    }

    public DataResponseTicket asignarTicket(DataAsignarTicket dataAsignar){
        Ticket ticket = this.ticketRespository.getReferenceById(dataAsignar.id());
        ticket.updateTicket(dataAsignar,null,null,null,null);
        return buildDataResponseTicketPut(ticket);

    }

    public void eliminarTicket(Long id){
        Ticket ticket = this.ticketRespository.getReferenceById(id);
        this.ticketRespository.delete(ticket);
    }

    private List<DataListReplyTicket> buildDataListReplyTicket(Ticket ticket) {
        return ticket.getRespuestas().stream().map(DataListReplyTicket::new).collect(Collectors.toList());
    }

    private DataResponseTicket buildDataResponseTicketPut(Ticket ticket) {
        return new DataResponseTicket(ticket.getId(), ticket.getTitulo(), ticket.getDescripcion(),
                ticket.getFechaCreacion().toString(), buildDataResponseEstado(ticket),
                buildDataResponsePrioridad(ticket), buildDataResponseCategoria(ticket),
                builDataResponseCliente(ticket), builDataResponseAgente(ticket));
    }

    private DataResponseTicket buildDataResponseTicket(Ticket ticket){
        return new DataResponseTicket(ticket.getId(), ticket.getTitulo(), ticket.getDescripcion(), null,
                buildDataResponseEstado(ticket), buildDataResponsePrioridad(ticket), buildDataResponseCategoria(ticket),
                builDataResponseCliente(ticket), builDataResponseAgente(ticket));
    }
    private DataResponseCreateTicket buildDataResponseCreateTicket(Ticket ticket) {
        return new DataResponseCreateTicket(ticket.getId(), ticket.getTitulo(), ticket.getDescripcion(),
                ticket.getFechaCreacion().toString(), buildDataResponseEstado(ticket),
                buildDataResponsePrioridad(ticket), builDataResponseCliente(ticket) );
    }

    private DataResponseCliente builDataResponseCliente(Ticket ticket){
        return new DataResponseCliente(ticket.getCliente().getId(),ticket.getCliente().getNombre(),
                ticket.getCliente().getEmail());
    }
    private DataResponseAgente builDataResponseAgente(Ticket ticket){
        return new DataResponseAgente(ticket.getAgente().getId(),ticket.getAgente().getNombre(),
                ticket.getAgente().getEmail());
    }
    private DataResponseEstado buildDataResponseEstado(Ticket ticket){
        return new DataResponseEstado(ticket.getEstado().getCodigo(), ticket.getEstado().getNombre());
    }

    private DataResponsePrioridad buildDataResponsePrioridad(Ticket ticket){
        return new DataResponsePrioridad(ticket.getPrioridad().getCodigo(), ticket.getPrioridad().getNombre());
    }
    private DataResponseCategoria buildDataResponseCategoria(Ticket ticket){
        return new DataResponseCategoria(ticket.getCategoria().getCodigo(), ticket.getCategoria().getNombre());
    }

}
