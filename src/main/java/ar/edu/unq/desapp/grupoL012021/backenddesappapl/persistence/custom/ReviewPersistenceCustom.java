package ar.edu.unq.desapp.grupoL012021.backenddesappapl.persistence.custom;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Review;

import java.util.List;

public interface ReviewPersistenceCustom {

    List<Review> findAll(String contentName, Integer contentId, String type, String platform,
                         Boolean containsSpoilers, String language, String country, String orderBy,
                         Boolean descending, Integer pageNumber, Integer pageSize);
}
