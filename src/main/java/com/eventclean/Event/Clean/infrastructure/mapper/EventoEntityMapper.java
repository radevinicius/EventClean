package com.eventclean.Event.Clean.infrastructure.mapper;

import com.eventclean.Event.Clean.core.entities.Evento;
import com.eventclean.Event.Clean.infrastructure.persistance.EventoEntity;
import org.springframework.stereotype.Component;

@Component
public class EventoEntityMapper {

    public EventoEntity toEntity(Evento evento){
        return new EventoEntity(
                evento.id(),
                evento.nome(),
                evento.descricao(),
                evento.identificador(),
                evento.dataInicio(),
                evento.dataFim(),
                evento.localEvento(),
                evento.capacidade(),
                evento.organizador(),
                evento.tipo()
        );
    }
    public Evento toEvento(EventoEntity eventoEntity){
        return new Evento(
                eventoEntity.getId(),
                eventoEntity.getNome(),
                eventoEntity.getDescricao(),
                eventoEntity.getIdentificador(),
                eventoEntity.getDataInicio(),
                eventoEntity.getDataFim(),
                eventoEntity.getLocalEvento(),
                eventoEntity.getCapacidade(),
                eventoEntity.getOrganizador(),
                eventoEntity.getTipo()


        );
    }


}
