package com.devlatam.tickets.services;

import com.devlatam.tickets.domain.Agente;
import com.devlatam.tickets.dto.agente.*;
import com.devlatam.tickets.repositories.AgenteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AgenteService {
    private final AgenteRepository agenteRepository;

    public AgenteService(AgenteRepository agenteRepository){this.agenteRepository = agenteRepository;}

    public DataCreacionAgente crearAgente(DataRegistroAgente dataRegistro){
        Agente agente = this.agenteRepository.save(new Agente(dataRegistro));

        return new DataCreacionAgente(agente.getId(), agente.getNombre(), agente.getEmail(), agente.getTelefono());
    }
    public Page<DataListAgente> listAgentes(Pageable pageable){
        Page<Agente> agentes = this.agenteRepository.findAll(pageable);
        return agentes.map(DataListAgente::new);
    }
    public DataResponseAgente buscarAgente(Long id){
        Agente agente = this.agenteRepository.getReferenceById(id);
        return new DataResponseAgente(agente.getId(), agente.getNombre(), agente.getEmail());
    }
    public DataResponseUpdateAgente actualizarAgente(DataUpdateAgente dataUpdate){
        Agente agente = this.agenteRepository.getReferenceById(dataUpdate.id());
        var neoAgente = this.agenteRepository.save(agente);
        return new DataResponseUpdateAgente(neoAgente.getId(), neoAgente.getNombre(), neoAgente.getEmail(),
                neoAgente.getTelefono());
    }
    public void eliminarAgente(Long id){
        Agente agente = this.agenteRepository.getReferenceById(id);
        this.agenteRepository.delete(agente);
    }
}
