package com.eventclean.Event.Clean.infrastructure.mapper;

import com.eventclean.Event.Clean.core.entities.Evento;
import com.eventclean.Event.Clean.infrastructure.dtos.EventoDto;
import org.springframework.stereotype.Component;

@Component
public class EventoDtoMapper {

    public EventoDto eventoToDto(Evento evento){
        return new EventoDto(
                evento.id(),
                evento.nome(),
                evento.descricao(),
                evento.identificador(),
                evento.dataInicio(),
                evento.dataFim(),
                evento.localEvento(),
                evento.capacidade(),
                evento.organizador(),
                evento.tipo());
    }

    public Evento dtoToEvento(EventoDto dto){
        return new Evento(
                dto.id(),
                dto.nome(),
                dto.descricao(),
                dto.identificador(),
                dto.dataInicio(),
                dto.dataFim(),
                dto.localEvento(),
                dto.capacidade(),
                dto.organizador(),
                dto.tipo());
        }
}

