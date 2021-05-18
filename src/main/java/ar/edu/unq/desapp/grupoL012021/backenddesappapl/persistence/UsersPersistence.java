package ar.edu.unq.desapp.grupoL012021.backenddesappapl.persistence;


import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Users;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Configuration
@Repository
public interface UsersPersistence extends CrudRepository<Users, Integer> {

    Optional<Users> findById(Integer id);
    Optional <Users> findByusername (String username);
    List<Users> findAll();

}
