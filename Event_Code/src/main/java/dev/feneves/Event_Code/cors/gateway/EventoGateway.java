package dev.feneves.Event_Code.cors.gateway;

import dev.feneves.Event_Code.cors.entitys.Evento;

import java.util.List;
import java.util.Optional;

public interface EventoGateway {

    public Evento criarEvento(Evento evento);
    boolean existeidentificador (String identificador);

    public  String geradorIdentificador();

    public Evento buscarEvento(Long id);

    public List<Evento> buscarTodosEvento();

    public Optional< Evento> filtroPorIdentificador(String identificador);

}
