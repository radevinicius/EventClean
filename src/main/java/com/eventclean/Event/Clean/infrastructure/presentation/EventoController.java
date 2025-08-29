package com.eventclean.Event.Clean.infrastructure.presentation;

import com.eventclean.Event.Clean.core.entities.Evento;
import com.eventclean.Event.Clean.core.usecases.buscarEventoPorIdentificador;
import com.eventclean.Event.Clean.core.usecases.buscarEventoUseCase;
import com.eventclean.Event.Clean.core.usecases.criarEventoCase;
import com.eventclean.Event.Clean.infrastructure.dtos.EventoDto;
import com.eventclean.Event.Clean.infrastructure.mapper.EventoDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/")
public class EventoController {

    private final criarEventoCase criarEventoCase;
    private final EventoDtoMapper eventoDtoMapper;
    private final buscarEventoUseCase buscarEventoUseCase;
    private final buscarEventoPorIdentificador buscarEventoporIdentificador;

    public EventoController(com.eventclean.Event.Clean.core.usecases.criarEventoCase criarEventoCase, EventoDtoMapper eventoDtoMapper, com.eventclean.Event.Clean.core.usecases.buscarEventoUseCase buscarEventoUseCase, buscarEventoPorIdentificador buscarEventoporIdentificador) {
        this.criarEventoCase = criarEventoCase;
        this.eventoDtoMapper = eventoDtoMapper;
        this.buscarEventoUseCase = buscarEventoUseCase;
        this.buscarEventoporIdentificador = buscarEventoporIdentificador;
    }

    @PostMapping("/criarevento")
    public ResponseEntity<Map<String, Object>> criarEvento(@RequestBody EventoDto dto){

        Evento novoEvento = criarEventoCase.execute(eventoDtoMapper.dtoToEvento(dto));
        Map<String, Object> response = new HashMap<>();
        response.put("Mensagem: ", "O evento foi criado com sucesso");
        response.put("Mensagem: ", ResponseEntity.status(HttpStatus.CREATED).body(eventoDtoMapper.eventoToDto(novoEvento)));
        return ResponseEntity.ok(response);
    }
    @GetMapping("/listarevento")
    public ResponseEntity<List<EventoDto>> buscarEvento(){
        return ResponseEntity.status(HttpStatus.FOUND).body(buscarEventoUseCase.execute().stream().map(eventoDtoMapper::eventoToDto).toList());
    }
    @GetMapping("/{identificador}")
    public ResponseEntity<EventoDto> buscarPorIdentificador(@PathVariable String identificador){
        return ResponseEntity.status(HttpStatus.FOUND).body(eventoDtoMapper.eventoToDto(buscarEventoporIdentificador.execute(identificador)));

    }


}
