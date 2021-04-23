package ar.edu.unq.desapp.grupoL012021.backenddesappapl.webservices;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.PublicReview;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.services.PublicReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class PublicReviewWebService {

    @Autowired
    private PublicReviewService publicReviewService;

    @GetMapping("/api/publicReviews")
    public List<PublicReview> allPublicReviews() {
        List<PublicReview> publicReviews = publicReviewService.findAll();
        return publicReviews;
    }
}
