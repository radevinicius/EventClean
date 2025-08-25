package com.eventclean.Event.Clean.core.entities;

import com.eventclean.Event.Clean.core.enums.TipoEvento;
import java.time.LocalDateTime;

public record Evento(
        Long id,
        String nome,
        String descricao,
        String identificador,
        LocalDateTime datainicio,
        LocalDateTime dataFim,
        String local,
        String organizador,
        TipoEvento tipo


) {



}
