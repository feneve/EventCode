package dev.feneves.Event_Code.infrastructure.gateway;

import dev.feneves.Event_Code.cors.entitys.Evento;
import dev.feneves.Event_Code.cors.gateway.EventoGateway;
import dev.feneves.Event_Code.infrastructure.RandomIdentificador.GeradorRandomicoIdentificador;
import dev.feneves.Event_Code.infrastructure.mapper.EventoDtoMapper;
import dev.feneves.Event_Code.infrastructure.mapper.EventoEntityMapper;
import dev.feneves.Event_Code.infrastructure.persistence.EventoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EventoRepositoryGateway implements EventoGateway {

    private final EventoDtoMapper eventoDtoMapper;
    private final GeradorRandomicoIdentificador geradorRandomicoIdentificador;
    private  final EventoEntityMapper mapper;
    private final EventoRepository eventoRepository;

    public EventoRepositoryGateway(EventoDtoMapper eventoDtoMapper, GeradorRandomicoIdentificador geradorRandomicoIdentificador, EventoEntityMapper mapper, EventoRepository eventoRepository) {
        this.eventoDtoMapper = eventoDtoMapper;
        this.geradorRandomicoIdentificador = geradorRandomicoIdentificador;
        this.mapper = mapper;
        this.eventoRepository = eventoRepository;

    }

    public Evento criarEvento(Evento dto){
        return mapper.toDomin(eventoRepository.save(mapper.toEntitys(dto)));
    }

    @Override
    public boolean existeidentificador(String identificador) {
      return   eventoRepository.findAll().stream().anyMatch (eventoEntitys -> eventoEntitys.getIdentificador().equalsIgnoreCase(identificador));

    }

    @Override
    public String geradorIdentificador() {
        String identificador;
        do{
            identificador = geradorRandomicoIdentificador.generate();
        }while (eventoRepository.existsByidentificador(identificador));
        return identificador;
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
                .map(mapper::toDomin)
                .toList();
    }

    @Override
    public Optional<Evento> filtroPorIdentificador(String identificador) {
        return eventoRepository.findByidentificador(identificador).map(mapper::toDomin);
    }


}
