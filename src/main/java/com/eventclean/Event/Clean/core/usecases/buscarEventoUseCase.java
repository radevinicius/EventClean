package com.eventclean.Event.Clean.core.usecases;

import com.eventclean.Event.Clean.core.entities.Evento;

import java.util.List;

public interface buscarEventoUseCase {

    public List<Evento> execute();
}
