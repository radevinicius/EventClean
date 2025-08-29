package com.eventclean.Event.Clean.core.gateway;

import com.eventclean.Event.Clean.core.entities.Evento;

import java.util.List;
import java.util.Optional;

public interface EventoGateway {

    Evento criarEvento(Evento evento);
    List<Evento> buscarEvento();
    boolean verificarIdentificador(String identificador);
    Optional<Evento> buscarEventoPorIdentificador(String identificador);

}
