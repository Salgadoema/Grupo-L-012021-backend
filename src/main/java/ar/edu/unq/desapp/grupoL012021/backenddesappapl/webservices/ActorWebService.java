package ar.edu.unq.desapp.grupoL012021.backenddesappapl.webservices;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Actor;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actors")
@EnableAutoConfiguration
public class ActorWebService {

    @Autowired
    private ActorService actorService;

    @GetMapping
    public ResponseEntity<List<Actor>> allActors() {
        List<Actor> foundActors = actorService.findAll();
        if (foundActors == null) {
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(foundActors);
        }
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<Actor> actorById(@PathVariable("id") Integer id) {
        Actor foundActor = actorService.findById(id);
        if (foundActor == null) {
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(foundActor);
        }
    }

    @PostMapping("")
    public Actor create(@RequestBody Actor actor) {
        return actorService.save(actor);
    }

}
