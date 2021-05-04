package ar.edu.unq.desapp.grupoL012021.backenddesappapl.webservices;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Episode;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.services.EpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/episodes")
@EnableAutoConfiguration
public class EpisodeWebService {

    @Autowired
    private EpisodeService episodeService;

    @GetMapping("")
    public ResponseEntity<List<Episode>> allEpisodes() {
        List<Episode> episodes = episodeService.findAll();
        if(episodes == null) {
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(episodes);
        }
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<Episode> episodeById(@PathVariable("id") Integer id) {
        Episode episode = episodeService.findById(id);
        if(episode == null) {
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(episode);
        }
    }

    @PostMapping
    public Episode save(@RequestBody Episode episode) { return episodeService.save(episode); }

}
