package ar.edu.unq.desapp.grupoL012021.backenddesappapl.persistence.custom;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class ContentPersistenceCustomImpl implements ContentPersistenceCustom {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Content> findAll(String contentType, String contentStartYear, String contentEndYear,
                                 String crewMemberName, String genreName, Double rating,
                                 Boolean onlyLikedReviews, Integer pageNumber, Integer pageSize) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Content.class);
        Root contentRoot = cq.from(Content.class);

        List<Predicate> filterPredicates = new ArrayList<>();
        if( contentType != null && !contentType.isEmpty()) {
            filterPredicates.add(cb.equal(contentRoot.get("contentType"), contentType));
        }
        if(contentStartYear != null && !contentStartYear.isEmpty()) {
            filterPredicates.add(cb.equal(contentRoot.get("startYear"), contentStartYear));
        }
        if(contentEndYear != null && !contentEndYear.isEmpty()) {
            filterPredicates.add(cb.equal(cb.treat(contentRoot, Series.class).get("endYear"), contentEndYear));
        }
        if(crewMemberName != null && !crewMemberName.isEmpty()) {
            Join<Content, CrewMember> crewMemberJoin = contentRoot.join("crewMembers");
            filterPredicates.add(cb.equal(crewMemberJoin.get("name"), crewMemberName));
        }
        if(genreName != null && !genreName.isEmpty()) {
            Join<Content, Genre> genreJoin = contentRoot.join("genres");
            filterPredicates.add(cb.equal(genreJoin.get("genre"),genreName));
        }
        if (onlyLikedReviews != null || rating != null) {
            Join<Content, Review> reviewJoin = contentRoot.join("reviews");
            if(rating != null) {
                cq.groupBy(contentRoot.get("id"));
                cq.having(cb.greaterThanOrEqualTo(cb.avg(reviewJoin.get("rating")), rating));
            }
            if(onlyLikedReviews != null && onlyLikedReviews) {
                filterPredicates.add(cb.greaterThan(reviewJoin.get("likes"), reviewJoin.get("dislikes")));
            }
        }

        cq.distinct(true);
        cq.where(cb.and(filterPredicates.toArray(new Predicate[0])));

        TypedQuery tq = entityManager.createQuery(cq);

        return tq.getResultList();
    }
}
