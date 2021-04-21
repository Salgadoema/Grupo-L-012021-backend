package ar.edu.unq.desapp.grupoL012021.backenddesappapl.services;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Movie;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.persistence.MoviePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class MovieService {


    @Autowired
    private MoviePersistence repository;

    @Transactional
    public Movie save(Movie model) {
        return this.repository.save(model);
    }

    public Movie findByID(Integer id) {
        return this.repository.findById(id).get();
    }

    public List<Movie> findAll() {
        return (List<Movie>) this.repository.findAll();
    }
}

