package dev.feneves.Event_Code.cors.entitys;


import dev.feneves.Event_Code.cors.enuns.TipoEvento;

import java.time.LocalDateTime;

public record Evento(String nome,
                     String descricao,
                     Long id,
                     Integer capacidade,
                     TipoEvento tipo,
                     LocalDateTime inicioevento,
                     LocalDateTime terminoevento,
                     String local_evento,
                     String identificador,
                     String organizador
                     ) {
}
