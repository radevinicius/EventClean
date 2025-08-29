package com.eventclean.Event.Clean.infrastructure.persistance;

import com.eventclean.Event.Clean.core.entities.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventRepository extends JpaRepository<EventoEntity, Long> {

    Optional<Evento> findByIdentificador(String identificador);


}