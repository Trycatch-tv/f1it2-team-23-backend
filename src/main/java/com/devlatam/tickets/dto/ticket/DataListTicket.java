package com.devlatam.tickets.dto.ticket;



import com.devlatam.tickets.domain.Ticket;
import com.devlatam.tickets.dto.categoria.DataResponseCategoria;
import com.devlatam.tickets.dto.estado.DataResponseEstado;
import com.devlatam.tickets.dto.prioridad.DataResponsePrioridad;

public record DataListTicket(
        Long id, String titulo, String descripcion, DataResponseCategoria categoria, DataResponseEstado estado,
        DataResponsePrioridad prioridad
) {
    public DataListTicket(Ticket ticket){
        this(ticket.getId(), ticket.getTitulo(), ticket.getDescripcion(),
        new DataResponseCategoria(ticket.getCategoria().getCodigo(), ticket.getCategoria().getNombre()),
        new DataResponseEstado(ticket.getEstado().getCodigo(), ticket.getEstado().getNombre()),
        new DataResponsePrioridad(ticket.getPrioridad().getCodigo(), ticket.getPrioridad().getNombre()));
    }
}
