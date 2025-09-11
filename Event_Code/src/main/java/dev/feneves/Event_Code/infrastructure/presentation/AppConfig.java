package dev.feneves.Event_Code.infrastructure.presentation;

import dev.feneves.Event_Code.cors.gateway.EventoGateway;
import dev.feneves.Event_Code.cors.usecases.criarEventoCaseImp;
import dev.feneves.Event_Code.infrastructure.persistence.EventoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public criarEventoCaseImp criarEventoCaseImp(EventoGateway repository){
        return new criarEventoCaseImp(repository);
    }
}
