package ar.edu.unq.desapp.grupoL012021.backenddesappapl.persistence;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Content;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.persistence.custom.ContentPersistenceCustom;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Configuration
@Repository
public interface ContentPersistence extends JpaRepository<Content, Integer>, ContentPersistenceCustom {

    Optional<Content> findById(Integer id);

    List<Content> findAll();

    Page<Content> findAll(Pageable pageTest);

}
