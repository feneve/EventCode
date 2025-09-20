package dev.feneves.Event_Code.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorResponse {

    private String mensagem;
    private int status;
    private LocalDateTime localDateTime;
}
