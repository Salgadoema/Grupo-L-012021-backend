package ar.edu.unq.desapp.grupoL012021.backenddesappapl.model;

import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Movie {
    @Id
    private Integer id;

    @Column
    private String movieName;



    public Movie() {
        super();
    }

    public Movie(Integer id, String movieName) {
        super();
        this.id = id;
        this.movieName = movieName;
    }

    public Integer getId() {
        return id;
    }

    public String getMovieName() {
        return movieName;
    }
}
