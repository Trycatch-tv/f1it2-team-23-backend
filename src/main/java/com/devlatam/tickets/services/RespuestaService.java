package com.devlatam.tickets.services;

import com.devlatam.tickets.domain.Respuesta;
import com.devlatam.tickets.domain.Ticket;
import com.devlatam.tickets.dto.agente.DataResponseAgente;
import com.devlatam.tickets.dto.categoria.DataResponseCategoria;
import com.devlatam.tickets.dto.cliente.DataResponseCliente;
import com.devlatam.tickets.dto.estado.DataResponseEstado;
import com.devlatam.tickets.dto.prioridad.DataResponsePrioridad;
import com.devlatam.tickets.dto.respuesta.*;
import com.devlatam.tickets.dto.ticket.DataRespTicketReply;
import com.devlatam.tickets.dto.ticket.DataResponseTicket;
import com.devlatam.tickets.repositories.AgenteRepository;
import com.devlatam.tickets.repositories.TicketRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.devlatam.tickets.repositories.RespuestaRepository;

import java.time.LocalDateTime;

@Service
public class RespuestaService {
    private final RespuestaRepository respuestaRepository;
    private final TicketRespository ticketRespository;
    private final AgenteRepository agenteRepository;
    @Autowired
    public RespuestaService(RespuestaRepository respuestaRepository, TicketRespository ticketRespository,
                            AgenteRepository agenteRepository)
    {this.respuestaRepository = respuestaRepository;
     this.ticketRespository = ticketRespository;
     this.agenteRepository = agenteRepository;}

    public Page<DataListReplyTicket> listarRespuestas(Pageable pageable){
        Page<Respuesta> respuestas = respuestaRepository.findAll(pageable);
        return respuestas.map(DataListReplyTicket::new);
    }

    public DataResponseCreateReply crearRespuesta(DataCreacionRespuesta dataCreacion){
        Ticket ticket = ticketRespository.getReferenceById(dataCreacion.ticketId());
        Respuesta respuesta = respuestaRepository.save(new Respuesta(dataCreacion,ticket));
        return buildDataResponseCreateReply(respuesta);
    }

    public DataResponseRespuesta buscarRespuesta(Long id){
        Respuesta respuesta = respuestaRepository.getReferenceById(id);
        return buildDataResponseRespuesta(respuesta);
    }

    public DataResponseRespuesta actualizarRespuesta(DataUpdateRespuesta dataUpdate){
        Respuesta respuesta = respuestaRepository.getReferenceById(dataUpdate.id());
        if (dataUpdate.titulo() != null){
            respuesta.setTitulo(dataUpdate.titulo());
        }else if (dataUpdate.descripcion() != null){
            respuesta.setDescripcion(dataUpdate.descripcion());
        }else if (dataUpdate.finalizado() != null){
            respuesta.setFinalizado(dataUpdate.finalizado());
        }
        respuesta.setFechaModificacion(LocalDateTime.now());

        return buildDataResponseRespuesta(respuesta);

    }

    public void eliminarRespuesta(Long id){
        Respuesta respuesta = respuestaRepository.getReferenceById(id);
        respuestaRepository.delete(respuesta);
    }


    private DataResponseRespuesta buildDataResponseRespuesta(Respuesta resp) {
        return new DataResponseRespuesta(resp.getId(), resp.getTitulo(), resp.getDescripcion(), resp.getFechaCreacion().toString(),
                resp.getFechaModificacion().toString(),resp.getFinalizado(),
                new DataRespTicketReply(resp.getTicket().getId(),resp.getTicket().getTitulo(),
                        resp.getTicket().getDescripcion(), new DataResponseAgente(resp.getTicket().getAgente().getId(),
                        resp.getTicket().getAgente().getNombre(), resp.getTicket().getAgente().getEmail())
               ));
    }

    private DataResponseCreateReply buildDataResponseCreateReply(Respuesta respuesta) {
        return new DataResponseCreateReply(respuesta.getId(), respuesta.getTitulo(),respuesta.getDescripcion(),
                respuesta.getFechaCreacion().toString(),buildDataResponseTicket(respuesta));
    }

    private DataResponseTicket buildDataResponseTicket(Respuesta resp) {
        return new DataResponseTicket(resp.getTicket().getId(),resp.getTicket().getTitulo(),
                resp.getTicket().getDescripcion(), resp.getTicket().getFechaCreacion().toString(),
                buildDataResponseEstado(resp), buildDataResponsePrioridad(resp), buildDataResponseCategoria(resp),
                buildDataResposeCliente(resp), buildDataResponseAgente(resp));
    }

    private DataResponseEstado buildDataResponseEstado(Respuesta resp){
        return new DataResponseEstado(resp.getTicket().getEstado().getCodigo(),resp.getTicket().getEstado().getNombre());
    }
    private DataResponsePrioridad buildDataResponsePrioridad(Respuesta resp) {
        return new DataResponsePrioridad(resp.getTicket().getPrioridad().getCodigo(),resp.getTicket().getPrioridad().getNombre());
    }
    private DataResponseCategoria buildDataResponseCategoria(Respuesta resp) {
        return new DataResponseCategoria(resp.getTicket().getCategoria().getCodigo(),resp.getTicket().getCategoria().getNombre());
    }
    private DataResponseCliente buildDataResposeCliente(Respuesta resp) {
        return new DataResponseCliente(resp.getTicket().getCliente().getId(),resp.getTicket().getCliente().getNombre(),
                resp.getTicket().getCliente().getEmail());
    }
    private DataResponseAgente buildDataResponseAgente(Respuesta resp) {
        return new DataResponseAgente(resp.getTicket().getAgente().getId(),resp.getTicket().getAgente().getNombre(),
                resp.getTicket().getAgente().getEmail());
    }



}
