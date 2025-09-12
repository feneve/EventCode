package dev.feneves.Event_Code.cors.usecases;

import dev.feneves.Event_Code.cors.entitys.Evento;

import java.util.List;

public interface buscarEventoCase {

    public Evento execute (Long id);

    public  List<Evento> executeList ();
}
