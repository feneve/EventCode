package dev.feneves.Event_Code.cors.usecases;

import dev.feneves.Event_Code.cors.entitys.Evento;

public class buscarEventoImp implements buscarEventoCase{

    @Override
    public Evento buscarEvento(Evento evento) {
        return evento;
    }
}
