package dev.feneves.Event_Code.infrastructure.persistence;

import dev.feneves.Event_Code.cors.enuns.TipoEvento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
@Entity
@Table(name = "eventos") // pode usar minúsculo para evitar problemas no Postgres
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventoEntitys {


    @Column(nullable = false, length = 255)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer capacidade;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private TipoEvento tipo;


    @Column(name = "inicio_evento", nullable = false)
    private LocalDateTime inicioevento;

    @Column(name = "termino_evento", nullable = false)
    private LocalDateTime terminoevento;

    @Column(name = "local_evento", nullable = false)
    private String local_evento;

    @Column( unique = true)
    private String identificador;

    private String organizador;
}
