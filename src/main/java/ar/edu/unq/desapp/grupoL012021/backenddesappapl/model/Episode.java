package ar.edu.unq.desapp.grupoL012021.backenddesappapl.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;


@Entity
@DiscriminatorValue("Episode")
public class Episode extends Content {

    @Column
    private Integer season;

    public Episode() { super(); }

    public Episode(Integer id, String titleType, String episodePrimaryTitle, String originalTitle,
                   Integer releaseYear, List<Genre> genres, List<Actor> actors, List<Review> reviews,
                   Integer season) {
        super(id, "Episode", episodePrimaryTitle, originalTitle, releaseYear, genres, actors, reviews);

        this.season = season;
    }

    public Integer getSeason() { return season; }

    public void setSeason(Integer season) { this.season = season; }



}
