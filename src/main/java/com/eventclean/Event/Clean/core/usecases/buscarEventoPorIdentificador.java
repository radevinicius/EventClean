package com.eventclean.Event.Clean.core.usecases;

import com.eventclean.Event.Clean.core.entities.Evento;

import java.util.List;
import java.util.Optional;

public interface buscarEventoPorIdentificador {

    public Evento execute(String identificador);
}
