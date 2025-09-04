package dev.feneves.Event_Code.infrastructure.mapper;

import dev.feneves.Event_Code.infrastructure.dto.EventoDto;
import dev.feneves.Event_Code.infrastructure.persistence.EventoEntitys;
import jakarta.persistence.ManyToOne;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventoDtoMapper {


    EventoEntitys dtoparaEntitys(EventoDto eventoDto);

    EventoDto entitysparaDto(EventoEntitys eventoEntitys);

    List<EventoDto> listentityspraDto(List<EventoEntitys> list);
}
