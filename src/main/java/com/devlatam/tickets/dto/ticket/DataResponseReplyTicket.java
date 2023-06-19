package com.devlatam.tickets.dto.ticket;

import com.devlatam.tickets.domain.Agente;
import com.devlatam.tickets.domain.Categoria;
import com.devlatam.tickets.domain.Estado;
import com.devlatam.tickets.domain.Prioridad;
import com.devlatam.tickets.dto.agente.DataResponseAgente;
import com.devlatam.tickets.dto.categoria.DataResponseCategoria;
import com.devlatam.tickets.dto.cliente.DataResponseCliente;
import com.devlatam.tickets.dto.estado.DataResponseEstado;
import com.devlatam.tickets.dto.prioridad.DataResponsePrioridad;
import com.devlatam.tickets.dto.respuesta.DataListReplyTicket;

import java.time.LocalDateTime;
import java.util.List;

public record DataResponseReplyTicket(
            Long id, String titulo, String descripcion, String fechaCreacion, DataResponseCategoria categoria,
             DataResponsePrioridad prioridad,DataResponseEstado estado, DataResponseAgente agente
            ,List<DataListReplyTicket> respuestas

) {


}
