package ar.edu.unq.desapp.grupoL012021.backenddesappapl.webservices;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Review;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class ReviewWebService {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/api/reviews")
    public List<Review> allReviews() {
        List<Review> reviews = reviewService.findAll();
        return reviews;
    }

    @GetMapping("/api/reviews/byId/{id}")
    public ResponseEntity<Review> reviewById(@PathVariable("id") Integer id) {
        Review review = reviewService.findById(id);

        if (review == null) {
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(review);
        }
    }

}
