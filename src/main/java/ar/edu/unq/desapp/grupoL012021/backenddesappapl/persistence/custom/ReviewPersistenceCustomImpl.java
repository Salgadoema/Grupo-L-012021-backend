package ar.edu.unq.desapp.grupoL012021.backenddesappapl.persistence.custom;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Content;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.PublicReview;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Review;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class ReviewPersistenceCustomImpl implements ReviewPersistenceCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Review> findAll(String contentName, Integer contentId, String type, String platform,
                                Boolean containsSpoilers, String language, String country, String orderBy,
                                Boolean descending, Integer pageNumber, Integer pageSize) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Review.class);
        Root reviewRoot = cq.from(Review.class);

        Join<Content, Review> join = reviewRoot.join("content");

        List<Predicate> filterPredicates = new ArrayList<>();

        if(contentName != null && !contentName.isEmpty()) {
            filterPredicates.add(cb.equal(join.get("primaryTitle"), contentName));
        } else {
            filterPredicates.add(cb.equal(join.get("id"), contentId));
        }

        if(type != null && !type.isEmpty()) {
            filterPredicates.add(cb.equal(reviewRoot.get("type"), type));
        }
        if(platform != null && !platform.isEmpty()) {
            filterPredicates.add(cb.equal(reviewRoot.get("platformOrigin"),platform));
        }
        if(containsSpoilers != null) {

            /*
            Predicate predicateNull = cb.equal(reviewRoot.get("type"), "Premium");
            Predicate predicateFalse = cb.equal(cb.treat(reviewRoot, PublicReview.class).get("containsSpoilers"),containsSpoilers);
            Predicate predicateOR = cb.or(predicateFalse, predicateNull);
            filterPredicates.add(predicateOR);
            */
            filterPredicates.add(cb.equal(cb.treat(reviewRoot, PublicReview.class).get("containsSpoilers"),containsSpoilers));
        }
        if(language != null && !language.isEmpty()) {
            filterPredicates.add(cb.equal(reviewRoot.get("language"),language));
        }
        if(country != null && !country.isEmpty()) {
            filterPredicates.add(cb.equal(cb.treat(reviewRoot, PublicReview.class).get("geolocation"),country));
        }
        if(orderBy != null && !orderBy.isEmpty()) {
            if(descending) {
                cq.orderBy(cb.desc(reviewRoot.get(orderBy)));
            } else {
                cq.orderBy(cb.asc(reviewRoot.get(orderBy)));
            }
        }

        cq.distinct(true);

        Predicate predicates = cb.and(filterPredicates.toArray(new Predicate[0]));

        cq.where(predicates);

        TypedQuery tq = entityManager.createQuery(cq);
        tq.setFirstResult(pageNumber * pageSize);
        tq.setMaxResults(pageSize);


        return tq.getResultList();
    }
}
