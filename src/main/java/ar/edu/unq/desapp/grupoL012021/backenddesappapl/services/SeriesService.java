package ar.edu.unq.desapp.grupoL012021.backenddesappapl.services;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Series;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.persistence.SeriesPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SeriesService {

    @Autowired
    private SeriesPersistence repository;

    @Transactional
    public Series save(Series model) { return this.repository.save(model); }

    public Series findById(String id) {return this.repository.findById(id).get(); }

    public List<Series> findAll() { return this.repository.findAll(); }
}
