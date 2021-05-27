package ar.edu.unq.desapp.grupoL012021.backenddesappapl.persistence.custom;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Content;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.CrewMember;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Review;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Series;
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
                                 String crewMemberName, Double reviewRating, Boolean onlyLikedReviews,
                                 Integer pageNumber, Integer pageSize) {

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
        if (onlyLikedReviews != null || reviewRating != null) {
            Join<Content, Review> reviewJoin = contentRoot.join("reviews");
            if(reviewRating != null) {
                filterPredicates.add(cb.greaterThanOrEqualTo(reviewJoin.get("rating"), reviewRating));
            }
            if(onlyLikedReviews != null) {
                filterPredicates.add(cb.greaterThan(reviewJoin.get("likes"), reviewJoin.get("dislikes")));
            }
        }
        /*
        if(withRating != null) {
            //cq.groupBy(contentRoot.get("id"));

            //Join<Content, Review> reviewJoin = contentRoot.join("reviews");

            //cq.multiselect(reviewJoin, cb.avg(reviewJoin.get("rating")));

            //Predicate filterAverageTotalScore = cb.greaterThan(contentRoot.get("averageReviewScore"), withRating);
            //filterPredicates.add(filterAverageTotalScore);

            //ESTE ANDA SI SE REFIERE A QUE TENGA REVIEWS CON EL VALOR DADO O MAYOR
            filterPredicates.add(cb.greaterThanOrEqualTo(reviewJoin.get("rating"), withRating));
        }
        if (onlyLikedReviews != null) {
            //Join where more likes than dislikes
        }
         */
        cq.distinct(true);
        cq.where(cb.and(filterPredicates.toArray(new Predicate[0])));

        TypedQuery tq = entityManager.createQuery(cq);
        tq.setFirstResult(pageNumber * pageSize);
        tq.setMaxResults(pageSize);

        return tq.getResultList();
    }
}
