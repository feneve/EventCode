package dev.feneves.Event_Code.infrastructure;

import dev.feneves.Event_Code.infrastructure.dto.EventoDto;
import dev.feneves.Event_Code.infrastructure.mapper.EventoDtoMapper;
import dev.feneves.Event_Code.infrastructure.persistence.EventoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EventoService {

    private final EventoRepository repository;

    private final EventoDtoMapper mapper;

    public EventoDto criarEvento(EventoDto eventoDto){
        return mapper.entitysparaDto(repository.save(mapper.dtoparaEntitys(eventoDto)));

    }

    public List<EventoDto> listarEvento(){
        return mapper.listentityspraDto(repository.findAll());
    }
}
