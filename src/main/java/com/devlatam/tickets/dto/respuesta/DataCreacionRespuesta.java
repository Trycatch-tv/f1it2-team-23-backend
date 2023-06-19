package com.devlatam.tickets.dto.respuesta;

import com.devlatam.tickets.domain.Respuesta;
import com.devlatam.tickets.dto.ticket.DataResponseTicket;

public record DataCreacionRespuesta(

        Long id,
        String titulo,
        String descripcion,
        String fechaCreacion,
        Boolean finalizado,
        Long ticketId,
        Long agenteId
) {
    public  DataCreacionRespuesta(Respuesta respuesta){
        this(respuesta.getId(), respuesta.getTitulo(),respuesta.getDescripcion(), respuesta.getFechaCreacion().toString(),
                respuesta.getFinalizado(), respuesta.getTicket().getId(), respuesta.getTicket().getAgente().getId());
    }


}
