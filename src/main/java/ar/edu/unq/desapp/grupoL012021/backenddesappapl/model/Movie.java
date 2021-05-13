package ar.edu.unq.desapp.grupoL012021.backenddesappapl.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.ArrayList;

@Entity
@DiscriminatorValue("Movie")
public class Movie extends Content {

    public Movie() {
        super();
    }

    public Movie(Integer id, String moviePrimaryTitle, String originalTitle, Integer releaseYear,
                 ArrayList<Genre> genres, ArrayList<CrewMember> crew, ArrayList<Review> reviews) {
        super(id, "Movie", moviePrimaryTitle, originalTitle, releaseYear, genres, crew, reviews);
    }



}
