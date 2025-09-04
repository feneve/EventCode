package dev.feneves.Event_Code.infrastructure.mapper;

import dev.feneves.Event_Code.cors.enuns.TipoEvento;
import dev.feneves.Event_Code.infrastructure.dto.EventoDto;
import dev.feneves.Event_Code.infrastructure.persistence.EventoEntitys;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-04T19:31:34-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class EventoDtoMapperImpl implements EventoDtoMapper {

    @Override
    public EventoEntitys dtoparaEntitys(EventoDto eventoDto) {
        if ( eventoDto == null ) {
            return null;
        }

        EventoEntitys eventoEntitys = new EventoEntitys();

        eventoEntitys.setNome( eventoDto.nome() );
        eventoEntitys.setDescricao( eventoDto.descricao() );
        eventoEntitys.setCapacidade( eventoDto.capacidade() );
        eventoEntitys.setTipo( eventoDto.tipo() );
        eventoEntitys.setInicioevento( eventoDto.inicioevento() );
        eventoEntitys.setTerminoevento( eventoDto.terminoevento() );
        eventoEntitys.setLocalevento( eventoDto.localevento() );
        eventoEntitys.setIdentificador( eventoDto.identificador() );
        eventoEntitys.setOrganizador( eventoDto.organizador() );

        return eventoEntitys;
    }

    @Override
    public EventoDto entitysparaDto(EventoEntitys eventoEntitys) {
        if ( eventoEntitys == null ) {
            return null;
        }

        String nome = null;
        String descricao = null;
        Integer capacidade = null;
        TipoEvento tipo = null;
        LocalDateTime inicioevento = null;
        LocalDateTime terminoevento = null;
        String identificador = null;
        String organizador = null;
        String localevento = null;

        nome = eventoEntitys.getNome();
        descricao = eventoEntitys.getDescricao();
        capacidade = eventoEntitys.getCapacidade();
        tipo = eventoEntitys.getTipo();
        inicioevento = eventoEntitys.getInicioevento();
        terminoevento = eventoEntitys.getTerminoevento();
        identificador = eventoEntitys.getIdentificador();
        organizador = eventoEntitys.getOrganizador();
        localevento = eventoEntitys.getLocalevento();

        EventoDto eventoDto = new EventoDto( nome, descricao, capacidade, tipo, inicioevento, terminoevento, identificador, organizador, localevento );

        return eventoDto;
    }

    @Override
    public List<EventoDto> listentityspraDto(List<EventoEntitys> list) {
        if ( list == null ) {
            return null;
        }

        List<EventoDto> list1 = new ArrayList<EventoDto>( list.size() );
        for ( EventoEntitys eventoEntitys : list ) {
            list1.add( entitysparaDto( eventoEntitys ) );
        }

        return list1;
    }
}
