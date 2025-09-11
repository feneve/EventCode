package dev.feneves.Event_Code.infrastructure.presentation;

import dev.feneves.Event_Code.cors.entitys.Evento;
import dev.feneves.Event_Code.cors.usecases.criarEventoCaseImp;
import dev.feneves.Event_Code.infrastructure.dto.EventoDto;
import dev.feneves.Event_Code.infrastructure.gateway.EventoRepositoryGateway;
import dev.feneves.Event_Code.infrastructure.mapper.EventoDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    private  final EventoRepositoryGateway eventoRepositoryGateway;
    private  final EventoDtoMapper eventoDtoMapper;
    private final criarEventoCaseImp criarEventoCaseImp;
    public EventoController(EventoRepositoryGateway eventoRepositoryGateway, EventoDtoMapper eventoDtoMapper, criarEventoCaseImp criarEventoCaseImp) {
        this.eventoRepositoryGateway = eventoRepositoryGateway;
        this.eventoDtoMapper = eventoDtoMapper;
        this.criarEventoCaseImp = criarEventoCaseImp;
    }

    @PostMapping
    public Evento criarEvento(@RequestBody EventoDto dto){
        return criarEventoCaseImp.execute(eventoDtoMapper.toDomain(dto));

    }
}
