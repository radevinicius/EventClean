package com.eventclean.Event.Clean.infrastructure.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<EventoEntity, Long> {
}
