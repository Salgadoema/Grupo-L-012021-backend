package ar.edu.unq.desapp.grupoL012021.backenddesappapl.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public abstract class Reviewable {

    //tconst in imdb
    @Id
    @Column
    private String id;

    @Column
    private String titleType;

    @Column
    private String primaryTitle;

    @Column
    private String originalTitle;

    @Column
    private Date startYear;

    @ElementCollection
    private List<String> genres;

    @ManyToMany
    private List<Actor> actors;

    @OneToMany
    private List<Review> reviews;

}
