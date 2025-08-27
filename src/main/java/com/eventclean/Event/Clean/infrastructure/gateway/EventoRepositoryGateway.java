package com.eventclean.Event.Clean.infrastructure.gateway;

import com.eventclean.Event.Clean.core.entities.Evento;
import com.eventclean.Event.Clean.core.gateway.EventoGateway;
import com.eventclean.Event.Clean.infrastructure.mapper.EventoEntityMapper;
import com.eventclean.Event.Clean.infrastructure.persistance.EventRepository;
import com.eventclean.Event.Clean.infrastructure.persistance.EventoEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventoRepositoryGateway implements EventoGateway {

    private final EventRepository eventRepository;

    private final EventoEntityMapper mapper;

    public EventoRepositoryGateway(EventRepository eventRepository, EventoEntityMapper mapper) {
        this.eventRepository = eventRepository;
        this.mapper = mapper;
    }

    @Override
    public Evento criarEvento(Evento evento) {
        EventoEntity entityMapper = mapper.toEntity(evento);
        EventoEntity novoEvento = eventRepository.save(entityMapper);
        return mapper.toEvento(novoEvento);
    }



    @Override
    public List<Evento> buscarEvento() {
        return eventRepository.findAll().stream()
                .map(mapper::toEvento)
                .toList();
    }

}
