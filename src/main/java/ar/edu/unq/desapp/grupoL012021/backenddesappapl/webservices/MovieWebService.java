package ar.edu.unq.desapp.grupoL012021.backenddesappapl.webservices;


import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Movie;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.PremiumReview;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.PublicReview;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Review;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.services.MovieService;
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

    @PutMapping("api/movies/addreview/{id}")
    public ResponseEntity<Movie> addReview(@PathVariable("id") Integer id, @RequestBody PublicReview review) {
        Movie movie = movieService.findByID(id);
        if(movie == null) {
            return ResponseEntity.notFound().build();
        }
        else {
            PublicReview reviewToAdd = this.process(review, movie);
            movie.addReview(reviewToAdd);
            return ResponseEntity.ok(movie);
        }
    }

    private PublicReview process(PublicReview review, Movie movie) {
            PublicReview publicReview = new PublicReview(review.getId(),
                    review.getRating(), review.getPreview(), review.getFullReview(), review.getDateOfPublish(),
                    review.getPlatform(), review.getUsernameOnPlatform(), review.getlanguage(),
                    review.getlocation(), review.getContainSpoiler(), 0, 0, movie);
            return publicReview;
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

