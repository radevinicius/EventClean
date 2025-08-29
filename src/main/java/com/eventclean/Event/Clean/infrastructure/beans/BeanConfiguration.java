package com.eventclean.Event.Clean.infrastructure.beans;

import com.eventclean.Event.Clean.core.gateway.EventoGateway;
import com.eventclean.Event.Clean.core.usecases.*;
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
    @Bean
    public buscarEventoPorIdentificador buscarEventoPorIdentificador(EventoGateway eventoGateway){
        return new buscarEventoPorIdentificadorImpl(eventoGateway);
    }



}
