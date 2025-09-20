package dev.feneves.Event_Code.infrastructure.bens;

import dev.feneves.Event_Code.cors.gateway.EventoGateway;
import dev.feneves.Event_Code.cors.usecases.buscarEventoImp;
import dev.feneves.Event_Code.cors.usecases.criarEventoCaseImp;
import dev.feneves.Event_Code.cors.usecases.filtroEventoUseCase;
import dev.feneves.Event_Code.cors.usecases.filtroEventoUseCaseImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public criarEventoCaseImp criarEventoCaseImp(EventoGateway repository){
        return new criarEventoCaseImp(repository);
    }

    @Bean
    public buscarEventoImp buscarEventoImp(EventoGateway repository){
        return new buscarEventoImp(repository);
    }

    @Bean
    public filtroEventoUseCase filtroEventoUseCase(EventoGateway eventoGateway){
        return  new filtroEventoUseCaseImp(eventoGateway);
    }

}
