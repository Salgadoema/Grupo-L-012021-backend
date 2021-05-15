package ar.edu.unq.desapp.grupoL012021.backenddesappapl.services;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Users;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.persistence.UsersPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class UsersService {

    @Autowired
    private UsersPersistence repository;

    @Transactional
    public Users save(Users model) { return this.repository.save(model); }

    public Users findById(Integer id) { return this.repository.findById(id).get(); }

    public Users findByUserName(String username){return this.repository.findByusername(username).get();}

    public List<Users> findAll() { return this.repository.findAll(); }
}
