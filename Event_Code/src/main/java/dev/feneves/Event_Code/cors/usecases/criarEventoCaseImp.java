package dev.feneves.Event_Code.cors.usecases;

import dev.feneves.Event_Code.cors.entitys.Evento;
import dev.feneves.Event_Code.cors.gateway.EventoGateway;

public class criarEventoCaseImp implements criarEventoCase{

private final EventoGateway eventoGateway;

    public criarEventoCaseImp(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public Evento execute (Evento evento) {
    return eventoGateway.criarEvento(evento);
    }
}
