package dev.feneves.Event_Code.infrastructure.mapper;

import dev.feneves.Event_Code.cors.entitys.Evento;
import dev.feneves.Event_Code.infrastructure.dto.EventoDto;
import dev.feneves.Event_Code.infrastructure.persistence.EventoEntitys;
import jakarta.persistence.ManyToOne;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventoDtoMapper {

    public EventoDto toDto(Evento evento){
        return new EventoDto(
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

    public Evento toDomain(EventoDto evento){
        return new Evento(
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

    public EventoDto toEntity(EventoEntitys evento) {
        return new EventoDto(
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


