package com.devlatam.tickets.repositories;

import com.devlatam.tickets.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
