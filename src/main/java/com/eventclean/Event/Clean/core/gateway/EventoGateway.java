package com.eventclean.Event.Clean.core.gateway;

import com.eventclean.Event.Clean.core.entities.Evento;

import java.util.List;

public interface EventoGateway {

    Evento criarEvento(Evento evento);
    List<Evento> buscarEvento();


}
