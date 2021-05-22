package ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.metamodel;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Content;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.CrewMember;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Genre;
import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.Review;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Content.class)
public abstract class Content_ {

    public static volatile SingularAttribute<Content, String> primaryTitle;
    public static volatile ListAttribute<Content, CrewMember> crewMembers;
    public static volatile ListAttribute<Content, Review> reviews;
    public static volatile SingularAttribute<Content, String> originalTitle;
    public static volatile ListAttribute<Content, Genre> genres;
    public static volatile SingularAttribute<Content, Integer> startYear;
    public static volatile SingularAttribute<Content, Integer> id;
    public static volatile SingularAttribute<Content, String> contentType;

    public static final String PRIMARY_TITLE = "primaryTitle";
    public static final String CREW_MEMBERS = "crewMembers";
    public static final String REVIEWS = "reviews";
    public static final String ORIGINAL_TITLE = "originalTitle";
    public static final String GENRES = "genres";
    public static final String START_YEAR = "startYear";
    public static final String ID = "id";
    public static final String CONTENT_TYPE = "contentType";

}


