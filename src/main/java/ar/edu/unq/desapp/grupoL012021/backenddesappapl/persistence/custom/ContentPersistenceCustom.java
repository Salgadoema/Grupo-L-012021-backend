package ar.edu.unq.desapp.grupoL012021.backenddesappapl.persistence.custom;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Content;

import java.util.List;

public interface ContentPersistenceCustom {

    List<Content> findAll(String contentType, String contentStartYear, String contentEndYear,
                          String crewMemberName, Double rating, Boolean onlyLikedReviews,
                          Integer pageNumber, Integer pageSize);
}
