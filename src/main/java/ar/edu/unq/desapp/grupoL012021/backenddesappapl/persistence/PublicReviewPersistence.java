package ar.edu.unq.desapp.grupoL012021.backenddesappapl.persistence;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.PublicReview;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Configuration
@Repository
public interface PublicReviewPersistence extends JpaRepository<PublicReview, Integer> {

    Optional<PublicReview> findById(Integer id);

    List<PublicReview> findAll();

    @Query(value = "select * from Review where content_id = :reviewableid", nativeQuery = true)
    List<PublicReview> findByReviewable(@Param("reviewableid") Integer reviewableId);



}
