package ar.edu.unq.desapp.grupoL012021.backenddesappapl.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.ArrayList;

@Entity
@DiscriminatorValue("Movie")
public class Movie extends Reviewable {

    public Movie() {
        super();
    }

    public Movie(Integer id, String moviePrimaryTitle, String originalTitle, Integer releaseYear,
                 ArrayList<Genre> genres, ArrayList<Actor> actors, ArrayList<Review> reviews) {
        super(id, "Movie", moviePrimaryTitle, originalTitle, releaseYear, genres, actors, reviews);
    }



}
