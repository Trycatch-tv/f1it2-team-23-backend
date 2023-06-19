package com.devlatam.tickets.dto.respuesta;

public record DataListReply(
        Long id, String titulo, String descripcion, String fechaCreacion, String fechaModificacion, Boolean finalizado,
        DataListReplyTicket ticket
) {
}
