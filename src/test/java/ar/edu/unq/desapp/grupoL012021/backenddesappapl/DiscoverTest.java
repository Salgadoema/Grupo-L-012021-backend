package ar.edu.unq.desapp.grupoL012021.backenddesappapl;

import ar.edu.unq.desapp.grupoL012021.backenddesappapl.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DiscoverTest {

    private Movie movie;
    private Review review;
    private Review review2;
    private Discover discover;
    private ArrayList<Content> contents = new ArrayList<>();
    private Movie movie2;
    private PublicReview publicReview;
    private PremiumReview premiumReview;
    private ArrayList<Review> reviews= new ArrayList<>();

    @BeforeEach
    public void setUp() {
        this.discover= new Discover (1, contents);
        this.review = new PublicReview(1, 4.0, "THIS IS A REVIEW",
                "THIS IS A FULL REVIEW", new Date(14/5/2020),
                "nefli", "nefliuser","esp",
                "casa", true,0,0, Mockito.mock(Content.class));

        this.review2 = new PublicReview(1, 2.0, "THIS IS A REVIEW",
                "THIS IS A FULL REVIEW", new Date(14/5/2020),
                "nefli", "nefliuser","esp",
                "casa", true,0,0, Mockito.mock(Content.class));

        this.movie2 = new Movie(2,
                "Die Hard",
                "Die Hard",
                1988,
                Mockito.mock(ArrayList.class), //genres
                Mockito.mock(ArrayList.class),//actors
                reviews);//reviews

        reviews.add(review);

        this.movie = new Movie(1,
                 "Die Hard",
                 "Die Hard",
                 1988,
                 Mockito.mock(ArrayList.class), //genres
                 Mockito.mock(ArrayList.class),//actors
                 reviews);//reviews


        this.movie2.addReview(review2);

    }

    @Test
    public void buscarpeliculasconReseĆ±asmayorA4Estrellas(){
       movie.addReview(review);
       movie.addReview(review);

        discover.addMovie(movie);
        discover.addMovie(movie);


        assertEquals(true, discover.searchMoviesByReviewStar(3).contains(movie));
        assertEquals(false, discover.searchMoviesByReviewStar(3).contains(movie2));

    }
}
