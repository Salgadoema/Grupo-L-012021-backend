package ar.edu.unq.desapp.grupoL012021.backenddesappapl.webservices;


import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Movie;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.PublicReview;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.services.MovieService;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.services.PublicReviewService;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.services.dto.ReviewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@EnableAutoConfiguration
public class MovieWebService  {

    @Autowired
    private MovieService movieService;
    @Autowired
    private PublicReviewService reviewService;

    @PostMapping("/api/movies/save")
    public void addMovie(@RequestBody Movie movie) {
        movieService.save(movie);
    }

    @GetMapping("/api/movies")
    public List<Movie> allMovie() {
        List<Movie> list = movieService.findAll();;
        return list;
    }

    @GetMapping("/api/movies/byId/{id}")
    public ResponseEntity<Movie> movieById(@PathVariable("id") Integer id) {
        Movie movie = movieService.findByID(id);
        if(movie == null) {
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(movie);
        }
    }

    @PutMapping("api/movies/addreview/public/{id}")
    public ResponseEntity<Movie> addReview(@PathVariable("id") Integer id, @RequestBody ReviewDTO review) {
        Movie movie = movieService.findByID(id);
        if(movie == null) {
            return ResponseEntity.notFound().build();
        }
        else {
            PublicReview reviewToAdd = review.modelPublic(movie);
            movie.addReview(reviewToAdd);
            movieService.save(movie);
            return ResponseEntity.ok(movie);
        }
    }

    @RequestMapping(value = "/api/version", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getVersion() {
        String version = "0.2.1";
        Map<String, String> resultado = new HashMap<String, String>();
        resultado.put("version", version);
        return ResponseEntity.ok().body(resultado);
    }

}

