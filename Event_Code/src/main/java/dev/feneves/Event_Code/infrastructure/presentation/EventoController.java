package dev.feneves.Event_Code.infrastructure.presentation;

import dev.feneves.Event_Code.infrastructure.EventoService;
import dev.feneves.Event_Code.infrastructure.dto.EventoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {
    @Autowired
    EventoService eventoService;

    @PostMapping
    public ResponseEntity<EventoDto> salvarEvento(@RequestBody EventoDto dto){
        return ResponseEntity.ok(eventoService.criarEvento(dto));
    }

    @GetMapping
      public ResponseEntity<List<EventoDto>> listarEventos(){
        return ResponseEntity.ok(eventoService.listarEvento());
    }
}
