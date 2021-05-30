package ar.edu.unq.desapp.grupoL012021.backenddesappapl.persistence;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Review;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.persistence.custom.ReviewPersistenceCustom;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Configuration
@Repository
public interface ReviewPersistence extends JpaRepository<Review, Integer>, ReviewPersistenceCustom {

    Optional<Review> findById(Integer id);

    List<Review> findAll();

    @Query(value = "select * from Review where content_id = :contentid", nativeQuery = true)
    List<Review> findByContent(@Param("contentid") Integer reviewableId);


}
