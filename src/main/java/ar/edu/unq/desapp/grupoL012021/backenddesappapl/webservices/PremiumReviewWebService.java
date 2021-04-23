package ar.edu.unq.desapp.grupoL012021.backenddesappapl.webservices;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.PremiumReview;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.services.PremiumReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class PremiumReviewWebService {

    @Autowired
    private PremiumReviewService premiumReviewService;

    @GetMapping("api/premiumReviews")
    public List<PremiumReview> allPremiumReviews() {
        List<PremiumReview> premiumReviews = premiumReviewService.findAll();
        return premiumReviews;
    }
}
