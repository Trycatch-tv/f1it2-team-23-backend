package com.devlatam.tickets.dto.respuesta;

import com.devlatam.tickets.domain.Respuesta;
import com.devlatam.tickets.dto.agente.DataResponseAgente;
import com.devlatam.tickets.dto.ticket.DataResponseTicket;
import com.devlatam.tickets.dto.ticket.DataResponseTicketAgente;

public record DataListReplyTicket(
        Long id, String titulo, String descripcion, String fechaCrecion, String fechaModificacion, Boolean finalizado
      //  ,DataResponseTicket ticket
        ) {
    public DataListReplyTicket(Respuesta respuesta){
        this(respuesta.getId(), respuesta.getTitulo(), respuesta.getDescripcion(), respuesta.getFechaCreacion().toString(),
                respuesta.getFechaModificacion().toString(), respuesta.getFinalizado()
/* me genera error al tratar de llamar los datos del agente a la respuesta, al no haber una relacion directa de agente y
resùesta.
                ,new DataResponseTicketAgente(respuesta.getTicket().getId(), respuesta.getTicket().getAgente().getId(),
                        respuesta.getTicket().getAgente().getNombre(),respuesta.getTicket().getAgente().getEmail()) */
        );

    }
}
