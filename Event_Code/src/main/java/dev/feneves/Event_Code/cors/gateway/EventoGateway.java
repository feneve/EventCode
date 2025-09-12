package dev.feneves.Event_Code.cors.gateway;

import dev.feneves.Event_Code.cors.entitys.Evento;

import java.util.List;

public interface EventoGateway {

    public Evento criarEvento(Evento evento);

    public Evento buscarEvento(Long id);

    public List<Evento> buscarTodosEvento();
}
