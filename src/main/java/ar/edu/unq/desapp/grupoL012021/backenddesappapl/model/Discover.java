package ar.edu.unq.desapp.grupoL012021.backenddesappapl.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Discover {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;


    @OneToMany
    public List<Content> contents;


    public Discover() {
        super();
    }

    public Discover(Integer id, List<Content> contents) {
        this.id = id;
        this.contents = contents;
    }

    public void addMovie(Content movie) {
        this.contents.add(movie);
    }

    public ArrayList<Content> searchMoviesByReviewStar(int reviewStar) {


           ArrayList<Content> contentList= contents.stream()
                .filter(content -> content.hasSomeReviewWithMoreStarThan(reviewStar))
                   .collect(Collectors.toCollection(ArrayList::new));



        return contentList;
    }
}
