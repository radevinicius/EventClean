package com.eventclean.Event.Clean.core.usecases;

import com.eventclean.Event.Clean.core.entities.Evento;
import com.eventclean.Event.Clean.core.gateway.EventoGateway;
import com.eventclean.Event.Clean.infrastructure.exceptions.DuplicateEventException;

public class criarEventoCaseImpl implements criarEventoCase {


    public EventoGateway eventoGateway;

    public criarEventoCaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public Evento execute(Evento evento) {
        if (evento == null) {
            throw new IllegalArgumentException("Evento não pode ser nulo");
        }
        if (eventoGateway.verificarIdentificador(evento.identificador())){
            throw new DuplicateEventException(" Identificador: " + evento.identificador() + " já cadastrado");
        }
        return eventoGateway.criarEvento(evento);
    }
}
