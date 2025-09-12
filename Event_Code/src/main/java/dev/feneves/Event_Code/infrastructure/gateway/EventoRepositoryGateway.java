package dev.feneves.Event_Code.infrastructure.gateway;

import dev.feneves.Event_Code.cors.entitys.Evento;
import dev.feneves.Event_Code.cors.gateway.EventoGateway;
import dev.feneves.Event_Code.infrastructure.dto.EventoDto;
import dev.feneves.Event_Code.infrastructure.mapper.EventoDtoMapper;
import dev.feneves.Event_Code.infrastructure.mapper.EventoEntityMapper;
import dev.feneves.Event_Code.infrastructure.persistence.EventoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventoRepositoryGateway implements EventoGateway {

    private final EventoDtoMapper eventoDtoMapper;

    private  final EventoEntityMapper mapper;
    private final EventoRepository eventoRepository;

    public EventoRepositoryGateway(EventoDtoMapper eventoDtoMapper, EventoEntityMapper mapper, EventoRepository eventoRepository) {
        this.eventoDtoMapper = eventoDtoMapper;
        this.mapper = mapper;
        this.eventoRepository = eventoRepository;

    }

    public Evento criarEvento(Evento dto){
        return mapper.toDomin(eventoRepository.save(mapper.toEntitys(dto)));
    }

    @Override
    public Evento buscarEvento(Long id) {
        return mapper.toDomin(eventoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Id"+ id+" nao encontrado")));
    }
    @Override
    public List<Evento> buscarTodosEvento() {
        return eventoRepository.findAll()
                .stream()
                .map(mapper::toDomin) // transforma cada EventoEntity em Evento
                .toList();            // retorna como List<Evento>
    }



}
