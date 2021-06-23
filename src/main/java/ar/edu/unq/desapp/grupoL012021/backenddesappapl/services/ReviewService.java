package ar.edu.unq.desapp.grupoL012021.backenddesappapl.services;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.PremiumReview;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.PublicReview;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Review;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.persistence.PremiumReviewPersistence;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.persistence.PublicReviewPersistence;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.persistence.ReviewPersistence;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.dto.ReviewDTO;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.dto.ReviewFilterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ReviewService {

    @Autowired
    private ReviewPersistence repository;

    @Autowired
    private PublicReviewPersistence publicRepository;

    @Autowired
    private PremiumReviewPersistence premiumRepository;

    public Review findById(Integer id) { return this.repository.findById(id).get(); }

    public List<Review> findAll() { return this.repository.findAll(); }

    public List<Review> findAll(ReviewDTO review) {
        PublicReview publicExample = review.modelPublic();
        List<PublicReview> publicReviews = this.publicRepository.findAll(Example.of(publicExample));
        PremiumReview premiumExample = review.modelPremium();
        List<PremiumReview> premiumReviews = this.premiumRepository.findAll(Example.of(premiumExample));

        List<Review> reviews = Stream.concat(publicReviews.stream(), premiumReviews.stream())
                .distinct()
                .collect(Collectors.toList());

        return reviews;
    }

    public List<Review> findByContent(Integer id) { return this.repository.findByContent(id); }

    public List<Review> findAll(ReviewFilterDTO dto) {
        return repository.findAll(dto.getContentName(), dto.getContentId(), dto.getType(), dto.getPlatform(),
                dto.getContainsSpoilers(), dto.getLanguage(), dto.getCountry(), dto.getOrderBy(),
                dto.getDescending(), dto.getPageNumber(), dto.getPageSize());
    }
}
