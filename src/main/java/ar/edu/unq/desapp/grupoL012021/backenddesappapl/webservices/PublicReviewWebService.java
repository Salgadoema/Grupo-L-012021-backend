package ar.edu.unq.desapp.grupoL012021.backenddesappapl.webservices;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.PublicReview;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.services.PublicReviewService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@EnableAutoConfiguration
public class PublicReviewWebService {

    @Autowired
    private PublicReviewService publicReviewService;

    @GetMapping("/api/publicReviews")
    @ApiOperation(value = "Post a new Premium Review",
            notes = "Provide a Title id and the Premium Review data",
            response = PublicReview.class)
    public ResponseEntity<List<PublicReview>> allPublicReviews() {
        List<PublicReview> publicReviews = publicReviewService.findAll();
        if(publicReviews == null) {
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(publicReviews);
        }
    }

    @GetMapping("/api/publicReviews/byId/{id}")
    public ResponseEntity<PublicReview> publicReview(@PathVariable("id") Integer id) {
        PublicReview publicReview = publicReviewService.findById(id);
        if(publicReview == null) {
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(publicReview);
        }
    }


    @GetMapping("/api/publicReviews/from/{id}")
    @ResponseBody
    public ResponseEntity<List<PublicReview>> reviewsFrom(@PathVariable("id") Integer id) {
        List<PublicReview> publicReviews = publicReviewService.findByReviewable(id);
        if(publicReviews == null) {
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(publicReviews);
        }
    }

    @PutMapping("/api/publicReviews/addLike/{id}")
    public ResponseEntity<PublicReview> addLike(@PathVariable("id") Integer id) {
        PublicReview review = publicReviewService.findById(id);
        if(review == null) {
            return ResponseEntity.notFound().build();
        }
        else {
            review.addLike();
            final PublicReview updatedReview = publicReviewService.save(review);
            return ResponseEntity.ok(updatedReview);
        }
    }
    @PutMapping("/api/publicReviews/addDisLike/{id}")
    public ResponseEntity<PublicReview> addDisLike(@PathVariable("id") Integer id) {
        PublicReview review = publicReviewService.findById(id);
        if(review == null) {
            return ResponseEntity.notFound().build();
        }
        else {
            review.addDislike();
            final PublicReview updatedReview = publicReviewService.save(review);
            return ResponseEntity.ok(updatedReview);
        }
    }

    @PostMapping("/api/publicReviews")
    public PublicReview save(@RequestBody PublicReview review) { return publicReviewService.save(review);}



}
