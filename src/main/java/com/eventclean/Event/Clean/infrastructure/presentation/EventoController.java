package com.eventclean.Event.Clean.infrastructure.presentation;

import com.eventclean.Event.Clean.core.entities.Evento;
import com.eventclean.Event.Clean.core.usecases.buscarEventoUseCase;
import com.eventclean.Event.Clean.core.usecases.criarEventoCase;
import com.eventclean.Event.Clean.infrastructure.dtos.EventoDto;
import com.eventclean.Event.Clean.infrastructure.mapper.EventoDtoMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/")
public class EventoController {

    private final criarEventoCase criarEventoCase;
    private final EventoDtoMapper eventoDtoMapper;
    private final buscarEventoUseCase buscarEventoUseCase;

    public EventoController(com.eventclean.Event.Clean.core.usecases.criarEventoCase criarEventoCase, EventoDtoMapper eventoDtoMapper, com.eventclean.Event.Clean.core.usecases.buscarEventoUseCase buscarEventoUseCase) {
        this.criarEventoCase = criarEventoCase;
        this.eventoDtoMapper = eventoDtoMapper;
        this.buscarEventoUseCase = buscarEventoUseCase;
    }

    @GetMapping("/listarevento")
    public List<EventoDto> buscarEvento(){
        return buscarEventoUseCase.execute().stream().map(eventoDtoMapper::eventoToDto).toList();
    }

    @PostMapping("/criarevento")
    public EventoDto criarEvento(@RequestBody EventoDto dto){
        Evento novoEvento = criarEventoCase.execute(eventoDtoMapper.dtoToEvento(dto));
        return eventoDtoMapper.eventoToDto(novoEvento);
    }


}
