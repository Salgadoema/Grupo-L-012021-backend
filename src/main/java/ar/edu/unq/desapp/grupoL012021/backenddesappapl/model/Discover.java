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
    public List<Reviewable> reviewables;


    public Discover() {
        super();
    }

    public Discover(Integer id, List<Reviewable> reviewables) {
        this.id = id;
        this.reviewables = reviewables;
    }

    public void addMovie(Reviewable movie) {
        this.reviewables.add(movie);
    }

    public ArrayList<Reviewable> searchMoviesByReviewStar(int reviewStar) {


           ArrayList<Reviewable> reviewablesList= reviewables.stream()
                .filter(reviewable -> reviewable.hasSomeReviewWithMoreStarThan(reviewStar))
                   .collect(Collectors.toCollection(ArrayList::new));



        return reviewablesList;
    }
}
