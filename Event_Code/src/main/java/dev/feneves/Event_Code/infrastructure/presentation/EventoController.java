package dev.feneves.Event_Code.infrastructure.presentation;

import dev.feneves.Event_Code.cors.entitys.Evento;
import dev.feneves.Event_Code.cors.usecases.buscarEventoCase;
import dev.feneves.Event_Code.cors.usecases.buscarEventoImp;
import dev.feneves.Event_Code.cors.usecases.criarEventoCase;
import dev.feneves.Event_Code.cors.usecases.criarEventoCaseImp;
import dev.feneves.Event_Code.infrastructure.dto.EventoDto;
import dev.feneves.Event_Code.infrastructure.gateway.EventoRepositoryGateway;
import dev.feneves.Event_Code.infrastructure.mapper.EventoDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    private  final EventoRepositoryGateway eventoRepositoryGateway;
    private  final EventoDtoMapper eventoDtoMapper;
    private final criarEventoCase criarEventoCaseImp;
    private  final buscarEventoCase buscarEventoImp;
    public EventoController(EventoRepositoryGateway eventoRepositoryGateway, EventoDtoMapper eventoDtoMapper, criarEventoCaseImp criarEventoCaseImp, buscarEventoImp buscarEventoImp) {
        this.eventoRepositoryGateway = eventoRepositoryGateway;
        this.eventoDtoMapper = eventoDtoMapper;
        this.criarEventoCaseImp = criarEventoCaseImp;
        this.buscarEventoImp = buscarEventoImp;
    }

    @PostMapping
    public Evento criarEvento(@RequestBody EventoDto dto){
        return criarEventoCaseImp.execute(eventoDtoMapper.toDomain(dto));

    }

    @GetMapping("/{id}")
    public Evento buscarEvento(@PathVariable Long id){
        return buscarEventoImp.execute(id);
    }

    @GetMapping("/buscartodos")
    public List<Evento> buscarTodosEventos(){
        return buscarEventoImp.executeList();
    }
}
