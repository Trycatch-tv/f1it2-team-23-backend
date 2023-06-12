package com.devlatam.tickets.services;

import com.devlatam.tickets.domain.Cliente;
import com.devlatam.tickets.dto.cliente.*;
import com.devlatam.tickets.repositories.ClienteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){ this.clienteRepository = clienteRepository;}

    public DataCreacionCliente crearCliente(DataRegistroCliente dataRegistro){
        Cliente cliente = this.clienteRepository.save(new Cliente(dataRegistro));
        return new DataCreacionCliente(cliente.getId(), cliente.getNombre(), cliente.getTelefono(), cliente.getEmail());
    }

    public Page<DataListCliente> listaClientes(Pageable pageable){
        Page<Cliente> clientes = this.clienteRepository.findAll(pageable);
        return clientes.map(DataListCliente::new);
    }

    public DataResponseCliente buscarCliente(Long id){
        Cliente cliente = this.clienteRepository.getReferenceById(id);
        return new DataResponseCliente(cliente.getId(), cliente.getNombre(), cliente.getEmail());
    }

    public DataResponseUpdateCliente actualizarCliente(DataUpdateCliente dataUpdate){
        Cliente cliente = this.clienteRepository.getReferenceById(dataUpdate.id());
        var neocliente = this.clienteRepository.save(cliente);
        return new DataResponseUpdateCliente(neocliente.getId(), neocliente.getNombre(), neocliente.getEmail(),
                neocliente.getTelefono());

    }

    public void eliminarCliente(Long id){
        Cliente cliente = this.clienteRepository.getReferenceById(id);
        this.clienteRepository.delete(cliente);
    }

}
