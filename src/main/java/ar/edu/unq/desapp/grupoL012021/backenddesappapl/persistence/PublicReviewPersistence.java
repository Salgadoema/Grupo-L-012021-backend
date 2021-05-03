package ar.edu.unq.desapp.grupoL012021.backenddesappapl.persistence;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.PublicReview;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Configuration
@Repository
public interface PublicReviewPersistence extends CrudRepository<PublicReview, Integer> {

    Optional<PublicReview> findById(Integer id);

    List<PublicReview> findAll();

    @Query(value = "select * from Review where reviewable_id = :reviewableid", nativeQuery = true)
    List<PublicReview> findByReviewable(@Param("reviewableid") Integer reviewableId);

    //@Query(value = "update Review r set r.likes = r.likes + 1 where r.id = :id")
    //void addLike(@Param("id") Integer id);
    //


}
