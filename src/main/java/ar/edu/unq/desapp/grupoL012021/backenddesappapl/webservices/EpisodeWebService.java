package ar.edu.unq.desapp.grupoL012021.backenddesappapl.webservices;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Episode;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.services.EpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class EpisodeWebService {

    @Autowired
    private EpisodeService episodeService;

    @GetMapping("/api/episodes")
    public List<Episode> allEpisodes() {
        List<Episode> episodes = episodeService.findAll();
        return episodes;
    }
}
