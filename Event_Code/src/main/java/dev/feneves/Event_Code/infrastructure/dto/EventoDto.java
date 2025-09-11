package dev.feneves.Event_Code.infrastructure.dto;

import dev.feneves.Event_Code.cors.enuns.TipoEvento;

import java.time.LocalDateTime;

public record EventoDto(String nome,
                        String descricao,
                        Long id,
                        Integer capacidade,
                        TipoEvento tipo,
                        LocalDateTime inicioevento,
                        LocalDateTime terminoevento,
                        String local_evento,
                        String identificador,
                        String organizador
                       )
{ }
