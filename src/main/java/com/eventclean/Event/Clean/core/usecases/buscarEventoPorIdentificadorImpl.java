package com.eventclean.Event.Clean.core.usecases;

import com.eventclean.Event.Clean.core.entities.Evento;
import com.eventclean.Event.Clean.core.gateway.EventoGateway;
import com.eventclean.Event.Clean.infrastructure.exceptions.NotFoundEventoexception;

public class buscarEventoPorIdentificadorImpl implements buscarEventoPorIdentificador{

    public EventoGateway eventoGateway;

    public buscarEventoPorIdentificadorImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public Evento execute(String identificador) {
        return eventoGateway.buscarEventoPorIdentificador(identificador)
                .orElseThrow(() -> new NotFoundEventoexception(identificador + " não encontrado."));
    }
}
