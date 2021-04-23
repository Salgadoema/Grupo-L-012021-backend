package ar.edu.unq.desapp.grupoL012021.backenddesappapl.persistence;


import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Actor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Configuration
@Repository
public interface ActorPersistence extends CrudRepository<Actor, String> {

    Optional<Actor> findById(String id);

    List<Actor> findAll();

}
