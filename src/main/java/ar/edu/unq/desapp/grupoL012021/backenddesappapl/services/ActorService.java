package ar.edu.unq.desapp.grupoL012021.backenddesappapl.services;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Actor;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.persistence.ActorPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ActorService {

    @Autowired
    private ActorPersistence repository;

    @Transactional
    public Actor save(Actor model) { return this.repository.save(model); }

    public Actor findById(String id) { return this.repository.findById(id).get(); }

    public List<Actor> findAll() { return this.repository.findAll(); }
}
