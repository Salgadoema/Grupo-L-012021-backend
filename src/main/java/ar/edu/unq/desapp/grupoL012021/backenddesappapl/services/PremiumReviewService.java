package ar.edu.unq.desapp.grupoL012021.backenddesappapl.services;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.PremiumReview;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.persistence.PremiumReviewPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PremiumReviewService {

    @Autowired
    private PremiumReviewPersistence repository;

    @Transactional
    public PremiumReview save(PremiumReview model) { return this.repository.save(model); }

    public PremiumReview findById(String id) { return this.repository.findById(id).get(); }

    public List<PremiumReview> findAll() { return this.repository.findAll(); }
}
