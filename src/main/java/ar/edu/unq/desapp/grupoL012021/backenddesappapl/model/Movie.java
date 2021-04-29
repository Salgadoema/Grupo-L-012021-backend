package ar.edu.unq.desapp.grupoL012021.backenddesappapl.model;

import javax.persistence.Entity;
import java.util.ArrayList;

@Entity
public class Movie extends Reviewable {

    public Movie() {
        super();
    }

    public Movie(String id, String moviePrimaryTitle, String originalTitle, Integer releaseYear,
                 ArrayList<String> genres, ArrayList<Actor> actors, ArrayList<Review> reviews) {
        super(id, "Movie", moviePrimaryTitle, originalTitle, releaseYear, genres, actors, reviews);
    }



}
