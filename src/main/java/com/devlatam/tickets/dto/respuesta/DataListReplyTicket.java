package com.devlatam.tickets.dto.respuesta;

import com.devlatam.tickets.domain.Respuesta;
import com.devlatam.tickets.dto.agente.DataResponseAgente;
import com.devlatam.tickets.dto.categoria.DataResponseCategoria;
import com.devlatam.tickets.dto.estado.DataResponseEstado;
import com.devlatam.tickets.dto.prioridad.DataResponsePrioridad;
import com.devlatam.tickets.dto.ticket.DataResponseReplyTicket;


public record DataListReplyTicket(
        Long id, String titulo, String descripcion, String fechaCrecion, String fechaModificacion, Boolean finalizado
       , DataResponseReplyTicket ticket
        ) {
    public DataListReplyTicket(Respuesta resp){
        this(resp.getId(), resp.getTitulo(), resp.getDescripcion(), resp.getFechaCreacion().toString(),
             resp.getFechaModificacion().toString(), resp.getFinalizado(),
             new DataResponseReplyTicket(resp.getTicket().getId(), resp.getTicket().getTitulo(),
             resp.getTicket().getDescripcion(), resp.getTicket().getFechaCreacion().toString(),
             new DataResponseCategoria(resp.getTicket().getCategoria().getCodigo(), resp.getTicket().getCategoria().getNombre()),
             new DataResponsePrioridad(resp.getTicket().getPrioridad().getCodigo(), resp.getTicket().getPrioridad().getNombre()),
             new DataResponseEstado(resp.getTicket().getEstado().getCodigo(), resp.getTicket().getEstado().getNombre()),
             new DataResponseAgente(resp.getTicket().getAgente().getId(),resp.getTicket().getAgente().getNombre(),
                     resp.getTicket().getAgente().getEmail()),null));

    }
}
