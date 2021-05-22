package ar.edu.unq.desapp.grupoL012021.backenddesappapl.persistence.custom;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Content;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.CrewMember;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Review;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Series;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.metamodel.Content_;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.metamodel.CrewMember_;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class ContentPersistenceCustomImpl implements ContentPersistenceCustom {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Content> findAll(String contentType, String contentStartYear, String contentEndYear,
                                    String crewMemberName, Integer totalScore, Boolean onlyLikedReviews) {
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
        if(totalScore != null) {
            //AVG reviews score
        }
        if (onlyLikedReviews != null) {
            //Join where more likes than dislikes
        }
        cq.distinct(true);
        cq.where(cb.and(filterPredicates.toArray(new Predicate[0])));

        return entityManager.createQuery(cq).getResultList();
    }
}
