package dev.feneves.Event_Code.cors.usecases;

import dev.feneves.Event_Code.cors.entitys.Evento;
import dev.feneves.Event_Code.cors.gateway.EventoGateway;

import java.util.List;

public class buscarEventoImp implements buscarEventoCase{

    private final EventoGateway eventoGateway;

    public buscarEventoImp(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public Evento execute (Long id) {
        return eventoGateway.buscarEvento(id);
    }

    @Override
    public List<Evento> executeList() {
        return eventoGateway.buscarTodosEvento();
    }
}
