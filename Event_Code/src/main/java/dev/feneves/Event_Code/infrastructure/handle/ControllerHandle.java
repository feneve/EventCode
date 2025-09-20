package dev.feneves.Event_Code.infrastructure.handle;


import dev.feneves.Event_Code.infrastructure.dto.ErrorResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerHandle {

    @ExceptionHandler(DupplicateIdentificador.class)
    public ResponseEntity<Map<String,String>> handleDuplicateKey(DupplicateIdentificador ex){
        Map<String,String> response = new HashMap<>();
        response.put("Erro:", ex.getMessage());
        response.put("Mensagem:"," O identificar ja esta em uso");
      return new  ResponseEntity(response,HttpStatus.CONFLICT);
    }

    @ExceptionHandler(IdentificadorNaoEncontrado.class)
    public ResponseEntity<Map<String,String>> identificadornaoencontrado(IdentificadorNaoEncontrado ex){
        Map<String,String> response = new HashMap<>();
        response.put("Erro:", ex.getMessage());
        response.put("Mensagem:", "Identificador não encontrado");
        return new ResponseEntity(response,HttpStatus.NOT_FOUND);
    }

}
