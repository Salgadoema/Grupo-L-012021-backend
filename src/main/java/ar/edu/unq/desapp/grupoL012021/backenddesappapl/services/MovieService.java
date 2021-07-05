package ar.edu.unq.desapp.grupoL012021.backenddesappapl.services;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.config.RabbitMQConfig;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Movie;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.persistence.MoviePersistence;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class MovieService {


    @Autowired
    private MoviePersistence repository;
    @Autowired
    private RabbitTemplate template;

    @Transactional
    public Movie save(Movie model) {
        return this.repository.save(model);
    }

    public Movie saveAndNotify(Movie model) {
        Movie persistedMovie = this.repository.save(model);
        template.convertAndSend(RabbitMQConfig.EXCHANGE_NAME,RabbitMQConfig.ROUTING_KEY,persistedMovie.getId());
        return persistedMovie;
    }

    public Movie findByID(Integer id) {
        return this.repository.findById(id).get();
    }

    public List<Movie> findAll() {
        return (List<Movie>) this.repository.findAll();
    }
}

