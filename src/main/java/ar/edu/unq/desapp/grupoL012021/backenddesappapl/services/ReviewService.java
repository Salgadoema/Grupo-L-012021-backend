package ar.edu.unq.desapp.grupoL012021.backenddesappapl.services;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Review;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.persistence.ReviewPersistence;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.webservices.dto.ReviewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewPersistence repository;

    public Review findById(Integer id) { return this.repository.findById(id).get(); }

    public List<Review> findAll() { return this.repository.findAll(); }

    public List<Review> findAll(Review review) { return this.repository.findAll(Example.of(review)); }

    public List<Review> findByContent(Integer id) { return this.repository.findByContent(id); }
}
