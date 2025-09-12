package dev.feneves.Event_Code.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventoRepository extends JpaRepository<EventoEntitys,Long> {

    @Override
    Optional<EventoEntitys> findById(Long aLong);

    
}
