package ar.edu.unq.desapp.grupoL012021.backenddesappapl.persistence;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.PremiumReview;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Configuration
@Repository
public interface PremiumReviewPersistence extends CrudRepository<PremiumReview, String> {

    Optional<PremiumReview> findById(String id);

    List<PremiumReview> findAll();
}
