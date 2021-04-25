package ar.edu.unq.desapp.grupoL012021.backenddesappapl.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
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
    public List<Review> reviews;

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


    public String  getId(){
        return this.id;
    }


    public abstract void addReview(Review Review);

    public abstract Double getRating();

    public abstract ArrayList<Review> getReviews();

    public abstract Review getReview(String id);

    public abstract Review getReviewByPlatform(String nefli);

    public abstract ArrayList<Review> getReviewsByPlatform(String platform);

    public abstract ArrayList<Review> getReviewsByContainSpoiler(boolean containsSpoiler);

    public abstract ArrayList<Review> getReviewsByLanguage(String language);

    public abstract ArrayList<Review> getReviewsByGeoLocation(String usa);

    public abstract ArrayList<Review> getReviewsByType(String premium_review);

    public abstract ArrayList<Review> getReviewsLikes();

    public abstract ArrayList<Review> getReviewsDislikes();

    public abstract ArrayList<Review> getReviewsOrderByLikes();

    public abstract void reportReview(String r_1);

    public abstract boolean hasSomeReviewWithMoreStarThan(int reviewStar);
}
