package com.devlatam.tickets.controllers;

import com.devlatam.tickets.dto.cliente.*;
import com.devlatam.tickets.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
    private final ClienteService clienteService;
    @Autowired
    public ClienteController(ClienteService clienteService){this.clienteService = clienteService;}

    @GetMapping
    public Page<DataListCliente> listarClientes(@PageableDefault(size = 20)Pageable pageable){
        return this.clienteService.listaClientes(pageable);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DataResponseCliente> buscarCliente(@PathVariable Long id){
        return ResponseEntity.ok(this.clienteService.buscarCliente(id));
    }
    @PostMapping
    public ResponseEntity<DataCreacionCliente> crearCliente(@RequestBody DataRegistroCliente dataRegistro,
                                                                    UriComponentsBuilder uriComponentsBuilder){
        var cliente = this.clienteService.crearCliente(dataRegistro);
        URI url = uriComponentsBuilder.path("/cliente/{id}").buildAndExpand(cliente.id()).toUri();
        return ResponseEntity.created(url).body(cliente);
    }
    @PostMapping("/{id}")
    public ResponseEntity<DataResponseUpdateCliente> actualizarCliente(@RequestBody DataUpdateCliente dataUpdate){
        return ResponseEntity.ok(this.clienteService.actualizarCliente(dataUpdate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCliente(@PathVariable Long id){
        this.clienteService.eliminarCliente(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
