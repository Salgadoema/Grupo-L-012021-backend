package ar.edu.unq.desapp.grupoL012021.backenddesappapl.webservices;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Series;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.services.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class SeriesWebService {

    @Autowired
    private SeriesService seriesService;

    @GetMapping("/api/series")
    public List<Series> allSeries() {
        List<Series> series = seriesService.findAll();
        return series;
    }
}
