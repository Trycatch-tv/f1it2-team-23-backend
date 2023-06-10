package com.devlatam.tickets.repositories;

import com.devlatam.tickets.domain.Prioridad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrioridadRepository extends JpaRepository<Prioridad, Character> {
}
