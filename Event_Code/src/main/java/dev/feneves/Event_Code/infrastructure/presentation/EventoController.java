package dev.feneves.Event_Code.infrastructure.presentation;

import dev.feneves.Event_Code.cors.entitys.Evento;
import dev.feneves.Event_Code.cors.usecases.*;
import dev.feneves.Event_Code.infrastructure.dto.EventoDto;
import dev.feneves.Event_Code.infrastructure.gateway.EventoRepositoryGateway;
import dev.feneves.Event_Code.infrastructure.mapper.EventoDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    private  final EventoRepositoryGateway eventoRepositoryGateway;
    private  final EventoDtoMapper eventoDtoMapper;
    private final criarEventoCase criarEventoCaseImp;
    private  final buscarEventoCase buscarEventoImp;
    private  final filtroEventoUseCase filtroEventoUseCase;
    public EventoController(EventoRepositoryGateway eventoRepositoryGateway, EventoDtoMapper eventoDtoMapper, criarEventoCaseImp criarEventoCaseImp, buscarEventoImp buscarEventoImp, filtroEventoUseCase filtroEventoUseCase) {
        this.eventoRepositoryGateway = eventoRepositoryGateway;
        this.eventoDtoMapper = eventoDtoMapper;
        this.criarEventoCaseImp = criarEventoCaseImp;
        this.buscarEventoImp = buscarEventoImp;
        this.filtroEventoUseCase = filtroEventoUseCase;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> criarEvento(@RequestBody EventoDto dto) {
        EventoDto novoevento = eventoDtoMapper.toDto(criarEventoCaseImp.execute(eventoDtoMapper.toDomain(dto)));
        Map<String, Object> response = new HashMap<>();
        response.put("Mensagem: ", "Evento criado com sucesso");
        response.put("Evento: ", novoevento);
        return ResponseEntity.ok(response);


    }

    @GetMapping("/{id}")
    public EventoDto buscarEvento(@PathVariable Long id){
        return  eventoDtoMapper.toDto(buscarEventoImp.execute(id));
    }

    @GetMapping("/buscartodos")
    public List<EventoDto> buscarTodosEventos(){
        return  buscarEventoImp.executeList().stream().map(eventoDtoMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/filtro/{identificador}")
        public ResponseEntity<Map<String,Object>> filtroPorIdentificador(@PathVariable String identificador){
        EventoDto response = eventoDtoMapper.toDto( filtroEventoUseCase.executeBuscaPorIdentificador(identificador));
        Map<String,Object> r = new HashMap<>();
           r.put("Identificador: ",identificador);
           r.put("Evento:",response);
        return ResponseEntity.ok(r);
    }
}
