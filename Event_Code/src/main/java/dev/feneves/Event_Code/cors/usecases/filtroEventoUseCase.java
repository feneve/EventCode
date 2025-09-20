package dev.feneves.Event_Code.cors.usecases;

import dev.feneves.Event_Code.cors.entitys.Evento;

import java.util.Optional;

public interface filtroEventoUseCase {

    public Evento executeBuscaPorIdentificador (String identificador);
}
