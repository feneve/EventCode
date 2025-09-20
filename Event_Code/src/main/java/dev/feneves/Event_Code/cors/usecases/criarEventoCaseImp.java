package dev.feneves.Event_Code.cors.usecases;

import dev.feneves.Event_Code.cors.entitys.Evento;
import dev.feneves.Event_Code.cors.gateway.EventoGateway;
import dev.feneves.Event_Code.infrastructure.handle.DupplicateIdentificador;

public class criarEventoCaseImp implements criarEventoCase{

private final EventoGateway eventoGateway;

    public criarEventoCaseImp(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public Evento execute (Evento evento) {
        if(evento.identificador() ==null || evento.identificador().isBlank()) {
            String identificador = eventoGateway.geradorIdentificador();
            Evento novoEvento = new Evento(
                    evento.nome(),
                    evento.descricao(),
                    evento.id(),
                    evento.capacidade(),
                    evento.tipo(),
                    evento.inicioevento(),
                    evento.terminoevento(),
                    evento.local_evento(),
                    identificador,
                    evento.organizador()
            );
            return eventoGateway.criarEvento(novoEvento);
        };
        if(eventoGateway.existeidentificador(evento.identificador())){
            throw new DupplicateIdentificador("Identificador ja existente");
        }

     return eventoGateway.criarEvento(evento);
    }
}
