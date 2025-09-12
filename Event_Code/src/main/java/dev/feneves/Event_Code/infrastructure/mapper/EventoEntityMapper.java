package dev.feneves.Event_Code.infrastructure.mapper;

import dev.feneves.Event_Code.cors.entitys.Evento;
import dev.feneves.Event_Code.infrastructure.dto.EventoDto;
import dev.feneves.Event_Code.infrastructure.persistence.EventoEntitys;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventoEntityMapper {

    public EventoEntitys toEntitys(Evento evento) {
        return new EventoEntitys(
                evento.nome(),
                evento.descricao(),
                evento.id(),
                evento.capacidade(),
                evento.tipo(),
                evento.inicioevento(),
                evento.terminoevento(),
                evento.local_evento(),
                evento.identificador(),
                evento.organizador()
        );
    }

    public Evento toDomin(EventoEntitys evento) {
        return new Evento(
                evento.getNome(),
                evento.getDescricao(),
                evento.getId(),
                evento.getCapacidade(),
                evento.getTipo(),
                evento.getInicioevento(),
                evento.getTerminoevento(),
                evento.getLocal_evento(),
                evento.getIdentificador(),
                evento.getOrganizador()
        );
    }
}
