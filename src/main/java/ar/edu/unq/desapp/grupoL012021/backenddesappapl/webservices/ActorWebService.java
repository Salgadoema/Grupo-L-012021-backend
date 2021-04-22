package ar.edu.unq.desapp.grupoL012021.backenddesappapl.webservices;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Actor;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class ActorWebService {

    @Autowired
    private ActorService actorService;

    @GetMapping
    public List<Actor> allActors() {
        List<Actor> actors = actorService.findAll();
        return actors;
    }
}
