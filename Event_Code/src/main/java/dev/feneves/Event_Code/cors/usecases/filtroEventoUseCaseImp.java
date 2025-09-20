package dev.feneves.Event_Code.cors.usecases;

import dev.feneves.Event_Code.cors.entitys.Evento;
import dev.feneves.Event_Code.cors.gateway.EventoGateway;
import dev.feneves.Event_Code.infrastructure.handle.IdentificadorNaoEncontrado;

import java.util.Optional;

public class filtroEventoUseCaseImp implements filtroEventoUseCase{

    private  final EventoGateway eventoGateway;

    public filtroEventoUseCaseImp(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public Evento executeBuscaPorIdentificador(String identificador) {

        return eventoGateway.filtroPorIdentificador(identificador).orElseThrow(()-> new IdentificadorNaoEncontrado("Identificar não encontrado"));
    }
}
