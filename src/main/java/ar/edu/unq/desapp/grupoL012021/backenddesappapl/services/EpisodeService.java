package ar.edu.unq.desapp.grupoL012021.backenddesappapl.services;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Episode;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.persistence.EpisodePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EpisodeService {

    @Autowired
    private EpisodePersistence repository;

    @Transactional
    public Episode save(Episode model) { return this.repository.save(model); }

    public Episode findById(Integer id) { return this.repository.findById(id).get(); }

    public List<Episode> findAll() { return this.repository.findAll(); }
}
