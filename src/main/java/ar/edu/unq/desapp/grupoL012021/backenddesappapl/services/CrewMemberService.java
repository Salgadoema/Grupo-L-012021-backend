package ar.edu.unq.desapp.grupoL012021.backenddesappapl.services;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.CrewMember;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.persistence.CrewMemberPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CrewMemberService {

    @Autowired
    private CrewMemberPersistence repository;

    @Transactional
    public CrewMember save(CrewMember model) { return this.repository.save(model); }

    public CrewMember findById(Integer id) { return this.repository.findById(id).get(); }

    public List<CrewMember> findAll() { return this.repository.findAll(); }
}
