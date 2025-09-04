package dev.feneves.Event_Code.infrastructure.dto;

import dev.feneves.Event_Code.cors.enuns.TipoEvento;

import java.time.LocalDateTime;

public record EventoDto(String nome,
                        String descricao,
                        Integer capacidade,
                        TipoEvento tipo,
                        LocalDateTime inicioevento,
                        LocalDateTime terminoevento,
                        String identificador,
                        String organizador,
                        String localevento)
{ }
