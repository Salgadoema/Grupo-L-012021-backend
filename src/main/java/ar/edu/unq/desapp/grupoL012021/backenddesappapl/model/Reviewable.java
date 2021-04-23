package ar.edu.unq.desapp.grupoL012021.backenddesappapl.model;

import javax.persistence.*;
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
    private Integer startYear;

    @ElementCollection
    private List<String> genres;

    @ManyToMany
    private List<Actor> actors;

    @OneToMany
    private List<Review> reviews;

    public Reviewable() {
        super();
    }

    public Reviewable(String id, String titleType, String primaryTitle, String originalTitle,
                      Integer startYear, List<String> genres, List<Actor> actors, List<Review> reviews) {

        this.id = id;
        this.titleType = titleType;
        this.primaryTitle = primaryTitle;
        this.originalTitle = originalTitle;
        this.startYear = startYear;
        this.genres = genres;
        this.actors = actors;
        this.reviews = reviews;
    }

    public String getTitle() {
        return primaryTitle;
    }
}
