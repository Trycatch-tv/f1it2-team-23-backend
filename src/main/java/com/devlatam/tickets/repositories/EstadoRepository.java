package com.devlatam.tickets.repositories;

import com.devlatam.tickets.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Character> {
}
