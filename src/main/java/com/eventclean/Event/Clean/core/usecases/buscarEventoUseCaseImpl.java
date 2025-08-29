package com.eventclean.Event.Clean.core.usecases;

import com.eventclean.Event.Clean.core.entities.Evento;
import com.eventclean.Event.Clean.core.gateway.EventoGateway;

import java.util.List;

public class buscarEventoUseCaseImpl implements buscarEventoUseCase {


    public EventoGateway eventoGateway;

    public buscarEventoUseCaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public List<Evento> execute(){
        return eventoGateway.buscarEvento();

    }
}
