package ar.edu.unq.desapp.grupoL012021.backenddesappapl.persistence;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Report;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Configuration
@Repository
public interface ReportPersistence extends CrudRepository<Report, String> {

    Optional<Report> findById(String id);

    List<Report> findAll();

    @Query(value = "select * from Report where review_id = :reviewid", nativeQuery = true)
    List<Report> fromReview(@Param("reviewid") Integer id);
}
