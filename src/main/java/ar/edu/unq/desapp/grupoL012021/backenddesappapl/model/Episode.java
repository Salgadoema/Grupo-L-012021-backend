package ar.edu.unq.desapp.grupoL012021.backenddesappapl.model;

import javax.persistence.Entity;
import java.util.ArrayList;

@Entity
public class Episode extends Reviewable {

    public Episode() {
        super();
    }

    public Episode(String id, String episodePrimaryTitle, String originalTitle, Integer releaseYear,
                   ArrayList<String> genres, ArrayList<Actor> actors, ArrayList<Review> reviews) {
        super(id, "Episode", episodePrimaryTitle, originalTitle, releaseYear, genres, actors, reviews);
    }
}
