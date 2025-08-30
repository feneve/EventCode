package dev.feneves.Event_Code.infrastructure.persistence;

import dev.feneves.Event_Code.cors.enuns.TipoEvento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Entity
@Table(name = "eventos") // pode usar minúsculo para evitar problemas no Postgres
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventoEntitys {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String nome;

    private String descricao;

    @Column(nullable = false)
    private Integer capacidade;
    @Column(columnDefinition = "tipos")
    @Enumerated(EnumType.STRING)
    private TipoEvento tipo;

    @Column(name = "inicio_evento", nullable = false)
    private LocalDateTime inicioEvento;

    @Column(name = "termino_evento", nullable = false)
    private LocalDateTime terminoEvento;

    @Column(name = "local_evento", nullable = false)
    private String localEvento;

    @Column(nullable = false, unique = true)
    private String identificador;

    private String organizador;
}
