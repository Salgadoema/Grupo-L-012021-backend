package ar.edu.unq.desapp.grupoL012021.backenddesappapl.services;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Genre;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.persistence.GenrePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class GenreService {

    @Autowired
    private GenrePersistence repository;

    @Transactional
    public Genre save(Genre model) { return this.repository.save(model); }

    public Genre findById(String id) { return this.repository.findById(id).get(); }

    public List<Genre> findAll() { return this.repository.findAll(); }
}
