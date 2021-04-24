package ar.edu.unq.desapp.grupoL012021.backenddesappapl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Date;

@Entity
public class Series extends Reviewable {

    @Column
    private Date endYear;

    public Series() {
        super();
    }

    @Override
    public void addReview(Review review) {
        reviews.add(review);
    }

    @Override
    public Double getRating() {
        return reviews.stream().mapToDouble(Review::getRating).sum()/reviews.size();
    }

    public Series(String id, String episodePrimaryTitle, String originalTitle, Integer releaseYear,
                  ArrayList<String> genres, ArrayList<Actor> actors, ArrayList<Review> reviews) {
        super(id, "Series", episodePrimaryTitle, originalTitle, releaseYear, genres, actors, reviews);
    }

}
