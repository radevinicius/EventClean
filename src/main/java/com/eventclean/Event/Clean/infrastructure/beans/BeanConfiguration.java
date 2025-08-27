package com.eventclean.Event.Clean.infrastructure.beans;

import com.eventclean.Event.Clean.core.gateway.EventoGateway;
import com.eventclean.Event.Clean.core.usecases.buscarEventoUseCase;
import com.eventclean.Event.Clean.core.usecases.buscarEventoUseCaseImpl;
import com.eventclean.Event.Clean.core.usecases.criarEventoCase;
import com.eventclean.Event.Clean.core.usecases.criarEventoCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public criarEventoCase criarEvento(EventoGateway eventoGateway){
        return new criarEventoCaseImpl(eventoGateway);
    }
    @Bean
    public buscarEventoUseCase buscarEvento(EventoGateway eventoGateway){
        return new buscarEventoUseCaseImpl(eventoGateway);
    }



}
