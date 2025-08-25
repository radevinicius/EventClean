package com.eventclean.Event.Clean.infrastructure.persistance;

import com.eventclean.Event.Clean.core.enums.TipoEvento;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Eventos")
public class EventoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private String identificador;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private String localEvento;
    private String capacidade;
    private String organizador;
    @Enumerated(EnumType.STRING)
    private TipoEvento tipo;
}
