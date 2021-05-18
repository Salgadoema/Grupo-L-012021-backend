package ar.edu.unq.desapp.grupoL012021.backenddesappapl.services;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.PublicReview;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Review;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.persistence.PublicReviewPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PublicReviewService {

    @Autowired
    private PublicReviewPersistence repository;

    @Transactional
    public PublicReview save(PublicReview model) { return this.repository.save(model); }

    public PublicReview findById(Integer id) { return this.repository.findById(id).get(); }

    public List<PublicReview> findAll() { return this.repository.findAll(); }

    public List<PublicReview> findAll(PublicReview review) { return this.repository.findAll(Example.of(review)); }

    public List<PublicReview> findByReviewable(Integer id) { return this.repository.findByReviewable(id); }

}
